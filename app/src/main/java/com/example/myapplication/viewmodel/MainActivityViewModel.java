package com.example.myapplication.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.RecyclerData;
import com.example.myapplication.network.RetroRepository;
import com.example.myapplication.network.RetroServiceInterface;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainActivityViewModel extends ViewModel {


    MutableLiveData<List<RecyclerData>> liveData;

    @Inject
    RetroServiceInterface retroServiceInterface;

    @Inject
    public MainActivityViewModel() {
        liveData  = new MutableLiveData<>();
    }

    public MutableLiveData<List<RecyclerData>> getLiveData(){
        return liveData;
    }
    public void makeApiCall(){
        RetroRepository repository = new RetroRepository(retroServiceInterface);
        repository.makeApiCall("us" , liveData);
    }
}
