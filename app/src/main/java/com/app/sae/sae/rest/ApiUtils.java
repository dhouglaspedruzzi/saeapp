package com.app.sae.sae.rest;

public class ApiUtils {

    public static final String BASE_URL = "https://crs.unochapeco.edu.br";

    public static ApiService getApiService() {
        return RestClient.getClient(BASE_URL).create(ApiService.class);
    }
}
