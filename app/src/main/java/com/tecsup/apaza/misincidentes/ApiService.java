package com.tecsup.apaza.misincidentes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Julio Cesar on 29/11/2017.
 */

public interface ApiService {

    String API_BASE_URL = "https://incidentes-synms.c9users.io";

    @GET("api/v1/incidentes")
    Call<List<Incidente>> getIncidentes();

}

