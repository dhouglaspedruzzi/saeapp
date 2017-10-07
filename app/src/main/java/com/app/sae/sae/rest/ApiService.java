package com.app.sae.sae.rest;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {


    @POST("sys/rpc/v1/reserva-espaco")
    @FormUrlEncoded
    Call<List<Horario>> getHorarios(@Field("espaco_id") long espacoId, @Field("data_base") Date dataBase);
}
