package com.gitintheshell.animationsshowcase;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Semyon on 03.06.2017.
 */

public abstract class BaseShowcaseActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcase_base);
        findViewById(R.id.restart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startAnim();
            }
        });
        ViewGroup frameViewGroup = (ViewGroup) findViewById(R.id.frame);
        getLayoutInflater().inflate(getLayoutId(), frameViewGroup, true);
    }

    @Override
    protected void onPostCreate(@Nullable final Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startAnim();
            }
        }, 300);
    }

    public abstract void startAnim();

    @LayoutRes
    public abstract int getLayoutId();

}

