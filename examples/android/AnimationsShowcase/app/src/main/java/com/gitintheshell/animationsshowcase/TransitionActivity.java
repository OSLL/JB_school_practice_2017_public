package com.gitintheshell.animationsshowcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TransitionActivity extends AppCompatActivity {

    @BindView(R.id.images)
    RecyclerView recyclerView;

    @ColorRes
    private int[] images = {R.drawable.f3, R.drawable.payne, R.drawable.tes4, R.drawable.mgs, R.drawable.vtmb, R.drawable.lis, R.drawable.kotor, R.drawable.isaac};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        final LayoutInflater layoutInflater = getLayoutInflater();
        final Picasso picasso = Picasso.with(this);
        recyclerView.setAdapter(new RecyclerView.Adapter<VH>() {
            @Override
            public VH onCreateViewHolder(final ViewGroup parent, final int viewType) {
                final View view = layoutInflater.inflate(R.layout.recycler_element, parent, false);
                return new VH(view);
            }

            @Override
            public void onBindViewHolder(final VH holder, final int position) {
                final int imageId = images[position];
                picasso.load(imageId).fit().centerCrop().into(holder.image);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        ImageActivity.start(TransitionActivity.this, holder.image, imageId);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return images.length;
            }
        });
    }

    static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView image;

        public VH(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
