package com.example.javacodersnairobi.model;

import com.google.gson.annotations.SerializedName;

public class GithubUsers {
    @SerializedName("avatar_url")
    String avatar;

    @SerializedName("login")
    String username;

    String bio;

    @SerializedName("public_repos")
    String repos;

    String followers;

    String following;

    @SerializedName("html_url")
    String profile;

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

    public String getProfileUrl() {
        return profile;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setRepos(String repos) {
        this.repos = repos;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
