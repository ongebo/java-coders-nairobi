package com.example.javacodersnairobi.presenter;

import com.example.javacodersnairobi.model.GithubUsers;
import com.example.javacodersnairobi.model.GithubUsersResponse;
import com.example.javacodersnairobi.service.GithubAPI;
import com.example.javacodersnairobi.service.GithubService;
import com.example.javacodersnairobi.view.AllProfilesView;
import com.example.javacodersnairobi.view.SingleProfileView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter {
    private GithubAPI api;

    public GithubPresenter() {
        api = new GithubService().getAPI();
    }

    public void getAllUsers(final AllProfilesView allProfilesView) {
        api.getAllProfiles().enqueue(new Callback<GithubUsersResponse>() {
            @Override
            public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                allProfilesView.displayProfiles(response.body());
            }

            @Override
            public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                allProfilesView.displayError();
            }
        });
    }

    public void getSingleUser(String handle, final SingleProfileView singleProfileView) {
        api.getSingleProfile(handle).enqueue(new Callback<GithubUsers>() {
            @Override
            public void onResponse(Call<GithubUsers> call, Response<GithubUsers> response) {
                singleProfileView.displayProfile(response.body());
            }

            @Override
            public void onFailure(Call<GithubUsers> call, Throwable t) {
                singleProfileView.displayError();
            }
        });
    }
}
