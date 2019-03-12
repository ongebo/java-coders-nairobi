package com.example.javacodersnairobi.model;

import com.google.gson.annotations.SerializedName;

public class GithubUsers {
    @SerializedName("avatar_url")
    String avatar;

    @SerializedName("name")
    String username;

    String bio;

    @SerializedName("public_repos")
    String repos;

    String followers;

    String following;

    public String getAvatar() {
        return avatar;
    }

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
    }

    public String getRepos() {
        return repos;
    }

    public String getFollowers() {
        return followers;
    }

    public String getFollowing() {
        return following;
    }
}
