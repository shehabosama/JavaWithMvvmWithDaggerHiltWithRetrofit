package com.example.myapplication.network;

import com.example.myapplication.model.RecyclerData;
import com.example.myapplication.model.RecyclerList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroServiceInterface {
    @GET("repositories")
    Call<RecyclerList>getDataFromGitHubApi(@Query("q") String query);
}
