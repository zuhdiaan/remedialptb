package com.example.project.aplikasigempa.route;

import com.example.project.aplikasigempa.response.ListGempa;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Route {
    @GET("/earthquakes/feed/v1.0/summary/2.5_day.geojson")
    Call<ListGempa> getListGempa();
}
