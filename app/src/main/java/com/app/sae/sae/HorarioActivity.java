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

import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HorarioActivity extends AppCompatActivity {

    private TextView titulo;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        this.titulo = (TextView) findViewById(R.id.titulo);
        this.dialog = new SpotsDialog(this, R.style.Dialog);

        final String id = getIntent().getStringExtra(MainActivity.ESPACO_ID);

        //Long.parseLong(id)
        //new SimpleDateFormat("yyyy-MM-dd").format(new Date())
        buscaHorarios(new BodyRequest("2017-03-10", (long) 150));
    }

    public void novaLeitura(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void buscaHorarios(BodyRequest bodyRequest) {
        dialog.show();

        ApiUtils.getApiService().getHorarios(bodyRequest).enqueue(new Callback<List<Horario>>() {

            @Override
            public void onResponse(Call<List<Horario>> call, Response<List<Horario>> response) {
                dialog.dismiss();

                List<Horario> data = response.body();

                if (!data.isEmpty()) {
                    Horario horario = data.get(0);
                    alteraTitulo(horario.getEspaco(), horario.getDataInicial());
                }

                preencheLista(data);
            }

            @Override
            public void onFailure(Call<List<Horario>> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void alteraTitulo(String nomeSala, String data) {
        titulo.setText(nomeSala + " - " + data);
    }

    private void preencheLista(List<Horario> horarios) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.horarios_rv);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewHorariosAdapter adapter = new RecyclerViewHorariosAdapter(horarios, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}
