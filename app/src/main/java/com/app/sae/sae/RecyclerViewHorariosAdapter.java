package com.app.sae.sae;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.sae.sae.rest.Horario;

public class RecyclerViewHorariosAdapter extends RecyclerView.Adapter<RecyclerViewHorariosViewHolder> {
    private Horario[] data;
    private Context context;

    public RecyclerViewHorariosAdapter(Horario[] data, Context context) {
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

        holder.responsavel.setText(reservado + " " + data[position].responsavel);
        holder.horario.setText(horario + " " + data[position].horario_inicial + " - " + data[position].horario_final);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}
