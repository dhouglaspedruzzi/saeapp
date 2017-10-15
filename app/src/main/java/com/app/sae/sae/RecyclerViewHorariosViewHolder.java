package com.app.sae.sae;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecyclerViewHorariosViewHolder extends RecyclerView.ViewHolder{

    public TextView responsavel;
    public TextView horario;
    public View view;

    public RecyclerViewHorariosViewHolder(View view) {
        super(view);
        this.view = view;
        this.horario = view.findViewById(R.id.horario);
        this.responsavel = view.findViewById(R.id.responsavel);
    }
}
