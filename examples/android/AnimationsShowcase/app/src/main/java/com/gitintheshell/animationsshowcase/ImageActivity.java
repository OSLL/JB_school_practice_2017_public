package com.gitintheshell.animationsshowcase;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageActivity extends AppCompatActivity {

    public static final String IMAGE_ID_EXTRA = "IMAGE_ID";

    @BindView(R.id.image)
    ImageView imageView;

    public static void start(final Activity activity, final ImageView imageView, @DrawableRes final int imageId) {
        Intent starter = new Intent(activity, ImageActivity.class);
        starter.putExtra(IMAGE_ID_EXTRA, imageId);

        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(activity, imageView, "img");

        ActivityCompat.startActivity(activity, starter, options.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image);

        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        @DrawableRes final int imageId = getIntent().getIntExtra(IMAGE_ID_EXTRA, R.drawable.f3);
        Picasso.with(this).load(imageId).fit().centerInside().into(imageView);

    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
