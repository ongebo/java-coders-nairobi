package com.example.javacodersnairobi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.javacodersnairobi.adapter.GithubAdapter;
import com.example.javacodersnairobi.model.GithubUsers;
import com.example.javacodersnairobi.model.GithubUsersResponse;
import com.example.javacodersnairobi.presenter.GithubPresenter;
import com.example.javacodersnairobi.view.AllProfilesView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AllProfilesView {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    public static final String EXTRA_USERNAME = "com.example.javacodersnairobi.USERNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.users_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        new GithubPresenter().getAllUsers(this);
    }

    public void showProfileDetails(GithubUsers profileInfo) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_USERNAME, profileInfo.getUsername());
        startActivity(intent);
    }

    @Override
    public void displayProfiles(GithubUsersResponse response) {
        List<GithubUsers> users = response.getGithubUsers();
        recyclerView.setAdapter(new GithubAdapter(users, this));
    }

    @Override
    public void displayError() {
        Log.i("Network", "Could not fetch data from the API.");
    }
}
