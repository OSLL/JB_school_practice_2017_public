package com.gitintheshell.animationsshowcase;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

public class InterpolatorActivity extends BaseShowcaseActivity {

    private static final long ANIM_TIME = 2000;
    private static final long Y_OFFSET = 500;

    private View redView;
    private View greenView;
    private View blueView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        redView = findViewById(R.id.red);
        greenView = findViewById(R.id.green);
        blueView = findViewById(R.id.blue);
    }

    @Override
    public void startAnim() {
        redView.setTranslationY(0.0f);
        greenView.setTranslationY(0.0f);
        blueView.setTranslationY(0.0f);
        redView.animate().yBy(Y_OFFSET).setDuration(ANIM_TIME).setInterpolator(new BounceInterpolator());
        greenView.animate().yBy(Y_OFFSET).setDuration(ANIM_TIME).setInterpolator(new OvershootInterpolator());
        blueView.animate().yBy(Y_OFFSET).setDuration(ANIM_TIME).setInterpolator(new DecelerateInterpolator());
    }

    @LayoutRes
    @Override
    public int getLayoutId() {
        return R.layout.activity_interpolator;
    }


}
