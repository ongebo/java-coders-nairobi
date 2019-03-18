package com.example.javacodersnairobi.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javacodersnairobi.MainActivity;
import com.example.javacodersnairobi.R;
import com.example.javacodersnairobi.model.GithubUsers;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubUsersViewHolder> {
    private List<GithubUsers> dataSet;
    private Context context;

    public static class GithubUsersViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public GithubUsersViewHolder(View view) {
            super(view);
            this.view = view;
        }
    }

    public GithubAdapter(List<GithubUsers> data, Activity parent) {
        dataSet = data;
        context = parent;
    }

    @Override
    public GithubUsersViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item, parent, false);
        return new GithubUsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GithubUsersViewHolder holder, int position) {
        final int pos = position;
        TextView textView = holder.view.findViewById(R.id.username);
        ImageView imageView = holder.view.findViewById(R.id.profile_image);
        textView.setText(dataSet.get(position).getUsername());
        Picasso.with(context).load(dataSet.get(position).getAvatar()).into(imageView);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)context;
                mainActivity.showProfileDetails(dataSet.get(pos));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
