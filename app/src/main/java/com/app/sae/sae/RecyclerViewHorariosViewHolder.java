package com.app.sae.sae;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecyclerViewHorariosViewHolder extends RecyclerView.ViewHolder{

    public TextView responsavel;
    public TextView horario;

    public RecyclerViewHorariosViewHolder(View view) {
        super(view);
        horario = view.findViewById(R.id.horario);
        responsavel = view.findViewById(R.id.responsavel);
    }
}
