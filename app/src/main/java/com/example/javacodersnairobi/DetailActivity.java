package com.example.javacodersnairobi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javacodersnairobi.model.GithubUsers;
import com.example.javacodersnairobi.presenter.GithubPresenter;
import com.example.javacodersnairobi.view.SingleProfileView;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity implements SingleProfileView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String userHandle = getIntent().getStringExtra(MainActivity.EXTRA_USERNAME);
        new GithubPresenter().getSingleUser(userHandle, this);
    }

    @Override
    public void displayProfile(GithubUsers profile) {
        View view = findViewById(R.id.detail_layout);

        // Obtain references to views on the profile details page
        ImageView profileImage = view.findViewById(R.id.profile_image);
        TextView username = view.findViewById(R.id.username);
        TextView bio = view.findViewById(R.id.bio);
        TextView repos = view.findViewById(R.id.repos);
        TextView followers = view.findViewById(R.id.followers);
        TextView following = view.findViewById(R.id.following);

        // Assign values to the referenced views
        Picasso.with(this).load(profile.getAvatar()).into(profileImage);
        username.setText(profile.getUsername());
        bio.setText((profile.getBio()));
        repos.setText(profile.getRepos());
        followers.setText(profile.getFollowers());
        following.setText(profile.getFollowing());
    }

    @Override
    public void displayError() {
        Log.i("Fetch Error", "Could not retrieve user profile data.");
    }
}
