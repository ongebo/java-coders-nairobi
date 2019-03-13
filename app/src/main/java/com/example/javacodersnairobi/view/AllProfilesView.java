package com.example.javacodersnairobi.view;

import com.example.javacodersnairobi.model.GithubUsersResponse;

public interface AllProfilesView {
    public void displayProfiles(GithubUsersResponse response);
    public void displayError();
}
