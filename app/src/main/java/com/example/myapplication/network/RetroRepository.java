package com.example.myapplication.network;


import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.model.RecyclerData;
import com.example.myapplication.model.RecyclerList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroRepository {
    private RetroServiceInterface retroServiceInterface;

    public RetroRepository(RetroServiceInterface retroServiceInterface){
        this.retroServiceInterface = retroServiceInterface;
    }

    public void makeApiCall(String query , MutableLiveData<List<RecyclerData>> liveData){
        Call<RecyclerList> call = retroServiceInterface.getDataFromGitHubApi(query);

        call.enqueue(new Callback<RecyclerList>() {
            @Override
            public void onResponse(Call<RecyclerList> call, Response<RecyclerList> response) {
            if (response.isSuccessful()){
                liveData.postValue(response.body().getItems());
            }else{
                liveData.postValue(null);
            }

            }

            @Override
            public void onFailure(Call<RecyclerList> call, Throwable t) {

                Log.e(TAG, "onFailure: "+t.getMessage());
                liveData.postValue(null);
            }
        });

    }
}
