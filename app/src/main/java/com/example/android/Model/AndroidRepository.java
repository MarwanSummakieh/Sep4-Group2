package com.example.android.Model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AndroidRepository {

    private static AndroidRepository instance;
    private MutableLiveData<Test> test;

    private AndroidRepository(){
        test = new MutableLiveData<>();
    }

    public static synchronized AndroidRepository getInstance(){
        if(instance == null){
            instance = new AndroidRepository();
        }
        return instance;
    }

    public LiveData<Test> getTest(){
        return test;
    }

    public void updateTest(String testName){
        AndroidAPI androidAPI = ServiceGenerator.getAndroidAPI();
        Call<APIResponse> call = androidAPI.getTest(testName);

        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                if (response.code() == 200){
                    test.setValue(response.body().getTest());
                }
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Log.i("Retrofit2", "Something is wrong in the API!");
            }
        });
    }


}
