package com.example.android.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("http://178.155.241.176:8080/DataValues?fbclid=IwAR0FJxv5F-lE-jixb2pWj6snsjXXV1BQJCr-qiEnh6VyH_9y9txRR8wjPjI")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static AndroidAPI androidAPI = retrofit.create(AndroidAPI.class);

    public static AndroidAPI getAndroidAPI() {
        return androidAPI;
    }
}
