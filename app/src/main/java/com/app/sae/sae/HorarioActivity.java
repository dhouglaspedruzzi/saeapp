package com.app.sae.sae;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.sae.sae.rest.Horario;

public class HorarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.horarios_rv);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Horario[] data = {
                (new Horario("Professor 1", "08:00", "12:00")),
                (new Horario("Professor 2", "13:30", "18:00")),
                (new Horario("Professor 3", "19:00", "22:35")),
        };

        RecyclerViewHorariosAdapter mAdapter = new RecyclerViewHorariosAdapter(data, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void novaLeitura(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
