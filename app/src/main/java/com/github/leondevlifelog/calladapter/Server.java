package com.github.leondevlifelog.calladapter;

import androidx.lifecycle.LiveData;

import retrofit2.http.GET;

public interface Server {
    @GET("test")
    LiveData<ResultWrapper<String>> get();
}
