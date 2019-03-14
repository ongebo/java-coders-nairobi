package com.example.javacodersnairobi.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubService {
    private Retrofit retrofit;
    private final String BASE_URL = "https://api.github.com/";

    public GithubService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public GithubAPI getAPI() {
        return retrofit.create(GithubAPI.class);
    }
}
