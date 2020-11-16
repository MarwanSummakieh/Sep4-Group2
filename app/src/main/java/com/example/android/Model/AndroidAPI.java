package com.example.android.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AndroidAPI {

    @GET("test")
    Call<APIResponse> getTest(@Path("") String test);
}
