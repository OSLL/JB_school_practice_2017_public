package com.gitintheshell.animationsshowcase;

import android.animation.ObjectAnimator;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

public class ImageTransformActivity extends BaseShowcaseActivity {

    private CardView imageWrapperView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageWrapperView = (CardView) findViewById(R.id.image_wrapper);
    }

    @Override
    public void startAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageWrapperView, "radius", 0.0f, Utils.dpToPx(this, 100));
        animator.setDuration(1500);
        animator.start();
    }

    @LayoutRes
    @Override
    public int getLayoutId() {
        return R.layout.activity_image_transform;
    }

}
