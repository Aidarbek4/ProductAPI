package com.example.productapi.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.productapi.models.ModelM;
import com.example.productapi.repositories.JemRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private JemRepository jemRepository;
    private LiveData<List<ModelM>> modelMResponseLiveData;

    public HomeViewModel() {
        jemRepository = new JemRepository();
        modelMResponseLiveData = jemRepository.getDashJeminyList();
    }

    public LiveData<List<ModelM>> getModelMResponseLiveData() {
        return modelMResponseLiveData;
    }
}