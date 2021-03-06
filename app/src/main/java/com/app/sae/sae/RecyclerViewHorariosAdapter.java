package com.app.sae.sae;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.sae.sae.rest.Horario;

import java.util.List;

public class RecyclerViewHorariosAdapter extends RecyclerView.Adapter<RecyclerViewHorariosViewHolder> {
    private List<Horario> data;
    private Context context;

    public RecyclerViewHorariosAdapter(List<Horario> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerViewHorariosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View layout = LayoutInflater.from(context).inflate(R.layout.lista_horarios_item, parent, false);

        return new RecyclerViewHorariosViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHorariosViewHolder holder, int position) {
        final String reservado = context.getResources().getString(R.string.reservado_por);
        final String horario = context.getResources().getString(R.string.horario);
        final Horario objeto = data.get(position);

        int background = R.color.colorList1;

        if (numeroPar(position)) {
            background = R.color.colorList2;
        }

        holder.view.setBackgroundColor(context.getResources().getColor(background));
        holder.view.setOnClickListener(new DetalhesOnClickListener(objeto));
        holder.responsavel.setText(reservado + " " + objeto.getResponsavel());
        holder.horario.setText(horario + " " + objeto.getHoraInicial() + " - " + objeto.getHoraFinal());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private boolean numeroPar(int numero) {
        return (numero % 2 == 0);
    }
}
