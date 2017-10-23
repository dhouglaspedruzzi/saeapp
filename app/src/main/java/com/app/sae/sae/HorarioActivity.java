package com.app.sae.sae;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sae.sae.rest.ApiUtils;
import com.app.sae.sae.rest.Horario;
import com.app.sae.sae.rest.BodyRequest;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HorarioActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, Callback<List<Horario>> {

    private TextView dataTitulo;
    private TextView espacoTitulo;
    private AlertDialog dialog;
    private String espacoAtualId;
    private String nomeEspacoAtual = "";
    private String dataSelecionadaAtual = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        dataTitulo = (TextView) findViewById(R.id.dataTitulo);
        espacoTitulo = (TextView) findViewById(R.id.espacoTitulo);
        dialog = new SpotsDialog(this, R.style.Dialog);

        espacoAtualId = getIntent().getStringExtra(MainActivity.ESPACO_ID);
        nomeEspacoAtual = getIntent().getStringExtra(MainActivity.DESCRICAO_ESPACO);
        dataSelecionadaAtual = dateToString(new Date());

        buscaHorarios(new BodyRequest(dateToString(new Date()), Long.parseLong(espacoAtualId)));
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", new Locale("pt","BR"));
        try {
            Date date = sdf.parse(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            dataSelecionadaAtual = sdf.format(date);
            atualizaTitulos();
            buscaHorarios(new BodyRequest(sdf.format(date), Long.parseLong(espacoAtualId)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResponse(Call<List<Horario>> call, Response<List<Horario>> response) {
        dialog.dismiss();
        List<Horario> data = response.body();

        if (!data.isEmpty()) {
            Horario horario = data.get(0);
            nomeEspacoAtual = horario.getEspaco();
            dataSelecionadaAtual = horario.getDataInicial();
        } else {
            Toast.makeText(getApplicationContext(), "Nenhuma informação encontrada para este espaço", Toast.LENGTH_LONG).show();
        }

        atualizaTitulos();
        preencheLista(data);
    }

    @Override
    public void onFailure(Call<List<Horario>> call, Throwable t) {
        dialog.dismiss();
        Toast.makeText(getApplicationContext(), "Erro ao buscar horários", Toast.LENGTH_LONG).show();
    }

    public void novaLeitura(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void selecionarData(View view) {
        String date = dateToString(new Date());
        String[] data = date.split("-");

        DatePickerDialog dpd = DatePickerDialog.newInstance(
                HorarioActivity.this,
                Integer.parseInt(data[0]),
                Integer.parseInt(data[1]) - 1,
                Integer.parseInt(data[2])
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    private void atualizaTitulos() {
        dataTitulo.setText(dataSelecionadaAtual);
        espacoTitulo.setText(nomeEspacoAtual);
    }

    private void buscaHorarios(BodyRequest bodyRequest) {
        dialog.show();
        ApiUtils.getApiService().getHorarios(bodyRequest).enqueue(this);
    }

    private void preencheLista(List<Horario> horarios) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.horarios_rv);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewHorariosAdapter adapter = new RecyclerViewHorariosAdapter(horarios, this);
        recyclerView.setAdapter(adapter);
    }

    private String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", new Locale("pt","BR"));

        return sdf.format(date);
    }
}
