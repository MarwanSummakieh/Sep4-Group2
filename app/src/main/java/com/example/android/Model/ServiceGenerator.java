package com.example.android.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static AndroidAPI androidAPI = retrofit.create(AndroidAPI.class);

    public static AndroidAPI getAndroidAPI() {
        return androidAPI;
    }
}
