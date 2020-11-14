package com.example.android.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.Model.AndroidRepository;
import com.example.android.Model.Test;

public class AndroidViewModel extends ViewModel {
    AndroidRepository repository;

    public AndroidViewModel(){
        repository = AndroidRepository.getInstance();
    }

    public LiveData<Test> getTest(){
        return repository.getTest();
    }

    public void updateTest(String a){
        repository.updateTest(a);
    }
}
