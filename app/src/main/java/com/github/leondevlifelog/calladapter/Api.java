package com.github.leondevlifelog.calladapter;

import com.readystatesoftware.chuck.ChuckInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Server server;
    private static OkHttpClient client;

    public static Server getInstance() {
        if (server == null) {
            Retrofit.Builder builder = new Retrofit.Builder();
            server = builder.addConverterFactory(GsonConverterFactory.create())
                    .client(getClient())
                    .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                    .baseUrl("https://easy-mock.com/mock/5d1a1488789c6873ede1b7d1/")
                    .build()
                    .create(Server.class);
        }

        return server;
    }

    public static OkHttpClient getClient() {
        if (client == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            client = builder.addInterceptor(new ChuckInterceptor(MyApp.getContext()))
                    .build();
        }
        return client;
    }
}
