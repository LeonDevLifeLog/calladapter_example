package com.github.leondevlifelog.calladapter.network;

import androidx.lifecycle.LiveData;

import com.github.leondevlifelog.calladapter.network.base.ResultWrapper;

import retrofit2.http.GET;

public interface ApiService {
    @GET("test")
    LiveData<ResultWrapper<String>> get();
}
