package com.app.sae.sae.rest;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {


    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("/sys/rpc/v1/reserva-espaco")
    Call<List<Horario>> getHorarios(@Body RequestHorario requestHorario);
}
