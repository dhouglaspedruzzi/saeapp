package com.app.sae.sae.rest;

import com.google.gson.annotations.Expose;

public class Horario {

    @Expose
    public String responsavel;

    @Expose
    public String horario_final;

    @Expose
    public String horario_inicial;

    public Horario(String responsavel, String horario_final, String horario_inicial) {
        this.responsavel = responsavel;
        this.horario_final = horario_final;
        this.horario_inicial = horario_inicial;
    }
}
