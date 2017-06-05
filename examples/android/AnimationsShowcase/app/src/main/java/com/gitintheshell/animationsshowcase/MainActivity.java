package com.gitintheshell.animationsshowcase;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.basic).setOnClickListener(new TransitionButtonClickListener(BasicAnimActivity.class));
        findViewById(R.id.image_transform).setOnClickListener(new TransitionButtonClickListener(ImageTransformActivity.class));
        findViewById(R.id.interpolator).setOnClickListener(new TransitionButtonClickListener(InterpolatorActivity.class));
        findViewById(R.id.color_interpolator).setOnClickListener(new TransitionButtonClickListener(ColorInterpolationActivity.class));
        findViewById(R.id.reveal).setOnClickListener(new TransitionButtonClickListener(RevealActivity.class));
        findViewById(R.id.transition).setOnClickListener(new TransitionButtonClickListener(TransitionActivity.class));
    }

    private class TransitionButtonClickListener implements View.OnClickListener {

        private Class<? extends Activity> clazz;

        public TransitionButtonClickListener(final Class<? extends Activity> clazz) {
            this.clazz = clazz;
        }

        @Override
        public void onClick(final View v) {
            Intent intent = new Intent(MainActivity.this, clazz);
            final ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeClipRevealAnimation(v, (int) v.getX(), (int) v.getY(), v.getWidth(), v.getHeight());
            ActivityCompat.startActivity(MainActivity.this, intent, activityOptionsCompat.toBundle());
        }
    }
}
