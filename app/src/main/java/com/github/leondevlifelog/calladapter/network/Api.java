package com.github.leondevlifelog.calladapter.network;

import com.github.leondevlifelog.calladapter.MyApp;
import com.github.leondevlifelog.calladapter.network.adapter.LiveDataCallAdapterFactory;
import com.readystatesoftware.chuck.ChuckInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static ApiService apiService;
    private static OkHttpClient client;

    public static ApiService getInstance() {
        if (apiService == null) {
            Retrofit.Builder builder = new Retrofit.Builder();
            apiService = builder.addConverterFactory(GsonConverterFactory.create())
                    .client(getClient())
                    .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                    .baseUrl("https://easy-mock.com/mock/5d1a1488789c6873ede1b7d1/")
                    .build()
                    .create(ApiService.class);
        }

        return apiService;
    }

    private static OkHttpClient getClient() {
        if (client == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            client = builder.addInterceptor(new ChuckInterceptor(MyApp.getContext()))
                    .build();
        }
        return client;
    }
}
