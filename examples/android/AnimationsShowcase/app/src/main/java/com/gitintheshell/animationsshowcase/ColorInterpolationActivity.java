package com.gitintheshell.animationsshowcase;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Property;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

public class ColorInterpolationActivity extends AppCompatActivity {


    private Toolbar toolbar;

    private ViewFlipper viewSwitcher;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    tintSystemBars(R.color.tab_notifications_color, R.color.tab_notifications_color_dark);
                    viewSwitcher.setDisplayedChild(0);
                    return true;
                case R.id.navigation_dashboard:
                    tintSystemBars(R.color.tab_history_color, R.color.tab_history_color_dark);
                    viewSwitcher.setDisplayedChild(1);
                    return true;
                case R.id.navigation_notifications:
                    tintSystemBars(R.color.tab_car_color, R.color.tab_car_color_dark);
                    viewSwitcher.setDisplayedChild(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_interpolation);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewSwitcher = (ViewFlipper) findViewById(R.id.view_switcher);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(500);
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(500);

        viewSwitcher.setInAnimation(fadeIn);
        viewSwitcher.setOutAnimation(fadeOut);

        toolbar.setTitle("Цвета");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
    }

    private void tintSystemBars(@ColorRes final int newToolbarColor, @ColorRes final int newStatusBarColor) {
        // Initial colors of each system bar.
        final int statusBarColor;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            statusBarColor = getWindow().getStatusBarColor();
        } else {
            statusBarColor = -1;
        }
        final int toolbarColor = ((ColorDrawable) toolbar.getBackground()).getColor();

        final int resToolbarToColor = getResources().getColor(newToolbarColor);
        final int resStatusbarToColor = getResources().getColor(newStatusBarColor);

        // Desired final colors of each bar.
        ValueAnimator anim = ValueAnimator.ofFloat(0, 1);

        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(final ValueAnimator animation) {
                // Use animation position to blend colors.
                float position = animation.getAnimatedFraction();

                // Apply blended color to the status bar.
                Integer blended = (Integer) argbEvaluator.evaluate(position, statusBarColor, resStatusbarToColor);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(blended);
                }

                // Apply blended color to the ActionBar.
                blended = (Integer) argbEvaluator.evaluate(position, toolbarColor, resToolbarToColor);
                ColorDrawable background = new ColorDrawable(blended);
                toolbar.setBackgroundDrawable(background);
            }
        });

        anim.setDuration(500).start();
    }

}
