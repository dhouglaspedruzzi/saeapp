package com.app.sae.sae;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.app.sae.sae.rest.Horario;

public class DetalhesOnClickListener implements View.OnClickListener {

    private Horario horario;

    public DetalhesOnClickListener(Horario horario) {
        this.horario = horario;
    }

    @Override
    public void onClick(View view) {
        final Context context = view.getContext();
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View detalhesView = inflater.inflate(R.layout.fragment_detalhes, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        alertDialog.setTitle("Mais Informações");
        alertDialog.setView( bind(detalhesView) );
        alertDialog.setCanceledOnTouchOutside(true);

        alertDialog.show();
    }

    private View bind(View view) {
        final TextView curso = view.findViewById(R.id.curso);
        curso.setText(this.horario.getCurso());

        final TextView turno = view.findViewById(R.id.turno);
        turno.setText(this.horario.getTurno());

        final TextView grade = view.findViewById(R.id.grade);
        grade.setText(this.horario.getCodgrade());

        final TextView periodo = view.findViewById(R.id.periodo);
        periodo.setText(this.horario.getFase());

        return view;
    }
}
