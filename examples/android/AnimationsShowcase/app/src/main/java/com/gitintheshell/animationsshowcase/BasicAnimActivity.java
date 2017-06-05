package com.gitintheshell.animationsshowcase;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BasicAnimActivity extends BaseShowcaseActivity {

    private View showAfterView;

    private View animatedItemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.animatedItemView = findViewById(R.id.anim_item);
        this.showAfterView = findViewById(R.id.show_after);
    }

    @Override
    public void startAnim() {
        this.animatedItemView.setScaleX(1.0f);
        this.animatedItemView.setScaleY(1.0f);
        this.animatedItemView.setTranslationX(0.0f);
        this.animatedItemView.setTranslationY(0.0f);
        showAfterView.setVisibility(View.GONE);
        this.animatedItemView.animate().yBy(130.0f).scaleXBy(1.1f).scaleYBy(1.1f).setDuration(1800).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(final Animator animation) {
                showAfterView.setVisibility(View.VISIBLE);
                showAfterView.setAlpha(0.0f);
                showAfterView.animate().alpha(1.0f).setDuration(300);
            }
        });
    }

    @LayoutRes
    @Override
    public int getLayoutId() {
        return R.layout.activity_basic_anim;
    }

}
