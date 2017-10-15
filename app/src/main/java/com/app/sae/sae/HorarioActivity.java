package com.app.sae.sae;

import android.content.Context;
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
import com.app.sae.sae.rest.RequestHorario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HorarioActivity extends AppCompatActivity {

    private Context context;
    private TextView salaTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        this.context = this;

        final String id = getIntent().getStringExtra(MainActivity.ESPACO_ID);

        salaTv = (TextView) findViewById(R.id.sala_tv);

        //Long.parseLong(id)
        //new SimpleDateFormat("yyyy-MM-dd").format(new Date())
        buscaHorarios(new RequestHorario("2017-03-10", (long) 150));
    }

    public void novaLeitura(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void buscaHorarios(RequestHorario requestHorario) {

        ApiUtils.getApiService().getHorarios(requestHorario).enqueue(new Callback<List<Horario>>() {

            @Override
            public void onResponse(Call<List<Horario>> call, Response<List<Horario>> response) {
                List<Horario> data = response.body();

                if (!data.isEmpty())
                    alteraEspaco(data.get(0).getEspaco());


                RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.horarios_rv);
                mRecyclerView.setHasFixedSize(true);

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
                mRecyclerView.setLayoutManager(mLayoutManager);

                RecyclerViewHorariosAdapter mAdapter = new RecyclerViewHorariosAdapter(data, context);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Horario>> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void alteraEspaco(String texto) {
        final String sala = context.getResources().getString(R.string.sala);
        salaTv.setText(sala + " " + texto);
    }
}
