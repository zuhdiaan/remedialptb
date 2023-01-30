package com.example.project.aplikasigempa.config;

import com.example.project.aplikasigempa.route.Route;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private String API_BASE_URL = "https://earthquake.usgs.gov";

    public Route configRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Route route = retrofit.create(Route.class);
        return route;
    }
}
