package com.app.sae.sae.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Horario {

    @SerializedName("responsavel")
    @Expose
    private String responsavel;

    @SerializedName("hora_fim")
    @Expose
    private String horaFinal;

    @SerializedName("hora_inicio")
    @Expose
    private String horaInicial;

    @SerializedName("codgrade")
    @Expose
    private String codgrade;

    @SerializedName("finalidade")
    @Expose
    private String finalidade;

    @SerializedName("codturma")
    @Expose
    private String codturma;

    @SerializedName("data_inicial")
    @Expose
    private String dataInicial;

    @SerializedName("dia_semana")
    @Expose
    private String diaSemana;

    @SerializedName("curso")
    @Expose
    private String curso;

    @SerializedName("turno")
    @Expose
    private String turno;

    @SerializedName("fase")
    @Expose
    private String fase;

    @SerializedName("espaco")
    @Expose
    private String espaco;

    public Horario(String responsavel, String hora_final, String hora_inicial, String codgrade, String finalidade, String codturma, String data_inicial, String dia_semana, String curso, String turno, String fase, String espaco) {
        this.responsavel = responsavel;
        this.horaFinal = hora_final;
        this.horaInicial = hora_inicial;
        this.codgrade = codgrade;
        this.finalidade = finalidade;
        this.codturma = codturma;
        this.dataInicial = data_inicial;
        this.diaSemana = dia_semana;
        this.curso = curso;
        this.turno = turno;
        this.fase = fase;
        this.espaco = espaco;
    }

    public Horario(String responsavel, String horaFinal, String horaInicial) {
        this.responsavel = responsavel;
        this.horaFinal = horaFinal;
        this.horaInicial = horaInicial;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getCodgrade() {
        return codgrade;
    }

    public void setCodgrade(String codgrade) {
        this.codgrade = codgrade;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public String getCodturma() {
        return codturma;
    }

    public void setCodturma(String codturma) {
        this.codturma = codturma;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getEspaco() {
        return espaco;
    }

    public void setEspaco(String espaco) {
        this.espaco = espaco;
    }
}
