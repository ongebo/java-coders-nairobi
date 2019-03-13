package com.example.javacodersnairobi.service;

import com.example.javacodersnairobi.model.GithubUsers;
import com.example.javacodersnairobi.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubAPI {
    @GET("search/users?q=type:User+location:Nairobi+language:JAVA")
    Call<GithubUsersResponse> getAllProfiles();

    @GET("users/{githubHandle}")
    Call<GithubUsers> getSingleProfile(@Path("githubHandle") String githubHandle);
}
