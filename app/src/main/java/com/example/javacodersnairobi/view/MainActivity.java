package com.example.javacodersnairobi.view;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.javacodersnairobi.R;
import com.example.javacodersnairobi.adapter.GithubAdapter;
import com.example.javacodersnairobi.model.GithubUsers;
import com.example.javacodersnairobi.model.GithubUsersResponse;
import com.example.javacodersnairobi.presenter.GithubPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AllProfilesView {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout refreshLayout;
    private GithubPresenter presenter;
    private ProgressBar progressBar;
    public static final String EXTRA_USERNAME = "com.example.javacodersnairobi.USERNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);

        recyclerView = findViewById(R.id.users_list);
        recyclerView.setHasFixedSize(true);
        setCardSpacing(4);
        int screenOrientation = getResources().getConfiguration().orientation;
        if (screenOrientation == Configuration.ORIENTATION_PORTRAIT)
            layoutManager = new GridLayoutManager(this, 2);
        else
            layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        presenter = new GithubPresenter();
        refreshLayout = findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getAllUsers(MainActivity.this);
            }
        });
        presenter.getAllUsers(this);
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
        refreshLayout.setRefreshing(false);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void displayError() {
        final Snackbar snackbar = Snackbar.make(findViewById(R.id.refreshLayout),
                "Could not fetch data from the API.", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("Reload", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getAllUsers(MainActivity.this);
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

    private void setCardSpacing(final int spacing) {
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                                       @NonNull RecyclerView parent,
                                       @NonNull RecyclerView.State state) {
                outRect.left = spacing;
                outRect.right = spacing;
                outRect.bottom = spacing;
                outRect.top = spacing;
            }
        });
    }
}
