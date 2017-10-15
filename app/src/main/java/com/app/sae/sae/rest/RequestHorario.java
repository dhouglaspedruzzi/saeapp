package com.app.sae.sae.rest;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class RequestHorario {

    @SerializedName("data_base")
    private String dataBase;

    @SerializedName("espaco_id")
    private Long espacoId;

    public RequestHorario(String dataBase, Long espacoId) {
        this.dataBase = dataBase;
        this.espacoId = espacoId;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public Long getEspacoId() {
        return espacoId;
    }

    public void setEspacoId(Long espacoId) {
        this.espacoId = espacoId;
    }
}
