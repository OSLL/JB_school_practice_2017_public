package com.gitintheshell.animationsshowcase;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageButton;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by Semyon on 04.06.2017.
 */

public class NewEventModeSelector extends Dialog {

    private static final int REVEAL_LENGTH = 300;

    private static final int BUTTON_REVEAL_ANIM_LENGTH = 250;

    View rootView;

    @BindView(R.id.note)
    ImageButton noteButton;

    @BindView(R.id.repair)
    ImageButton repairButton;

    @BindView(R.id.wash)
    ImageButton washButton;

    @BindView(R.id.fuel)
    ImageButton fuelButton;

    @BindView(R.id.mileage)
    ImageButton mileageButton;

    @BindViews({R.id.fuel,
            R.id.mileage,
            R.id.wash,
            R.id.note,
            R.id.repair
    })
    List<View> buttons;

    private Point startPoint;
    private int startRadius;

    public NewEventModeSelector(@NonNull final Context context, final Point startPoint, final int startRadius) {
        super(context, R.style.AppTheme_TransparentDialog);
        this.startPoint = startPoint;
        this.startRadius = startRadius;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        final LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        final @SuppressLint("InflateParams") View dialogView = layoutInflater.inflate(R.layout.dialog_new_event_mode_selector, null, false);
        setContentView(dialogView);
        rootView = dialogView.findViewById(R.id.container_view);

        ButterKnife.bind(this);
        Window window = getWindow();
        WindowManager.LayoutParams wlp;
        if (window != null) {
            wlp = window.getAttributes();
            wlp.width = android.view.WindowManager.LayoutParams.MATCH_PARENT;
            wlp.gravity = Gravity.BOTTOM;
            wlp.dimAmount = 0.3f;
            window.setAttributes(wlp);
        }

        rootView.setVisibility(View.INVISIBLE);
        setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(final DialogInterface dialog) {
                NewEventModeSelector.this.startActivityEnterAnim();
            }
        });
    }

    @Override
    public void dismiss() {
        destroyActivity();
    }

    private void realDismissDialog() {
        super.dismiss();
    }

    @Override
    public void onBackPressed() {
        destroyActivity();
    }

    private void destroyActivity() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivityExitAnim();
        } else {
            dismiss();
        }
    }

    private void startActivityEnterAnim() {
        float finalRadius = Math.max(rootView.getWidth(), rootView.getHeight());

        int[] location = new int[2];
        rootView.getLocationOnScreen(location);
        // координаты в dialog'e отличаются от координат в активити
        Point pointInDialog = new Point(startPoint.x - location[0], startPoint.y - location[1]);

        // create the animator for this view (the start radius is zero)
        Animator circularReveal = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            circularReveal = ViewAnimationUtils.createCircularReveal(rootView, pointInDialog.x, pointInDialog.y, startRadius, finalRadius);
            circularReveal.setDuration(REVEAL_LENGTH);
            // make the view visible and start the animation
            rootView.setVisibility(View.VISIBLE);
            circularReveal.start();
            circularReveal.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(final Animator animation) {
                    super.onAnimationEnd(animation);
                }
            });
        }

        int startDelay = (int) (REVEAL_LENGTH * 0.7);
        int additionalDelay = 0;
        for (final View button : buttons) {
            button.setScaleX(0.01f);
            button.setScaleY(0.01f);
            button.animate().scaleX(1).scaleY(1).setStartDelay(startDelay + additionalDelay).setDuration(BUTTON_REVEAL_ANIM_LENGTH).setInterpolator(new OvershootInterpolator()).start();
            additionalDelay += (BUTTON_REVEAL_ANIM_LENGTH * 0.4);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void startActivityExitAnim() {
        float finalRadius = Math.max(rootView.getWidth(), rootView.getHeight());

        int[] location = new int[2];
        rootView.getLocationOnScreen(location);
        // координаты в dialog'e отличаются от координат в активити
        Point pointInDialog = new Point(startPoint.x - location[0], startPoint.y - location[1]);

        Animator circularReveal = ViewAnimationUtils.createCircularReveal(rootView, pointInDialog.x, pointInDialog.y, finalRadius, startRadius);
        circularReveal.setDuration(REVEAL_LENGTH);
        circularReveal.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(final Animator animation) {
                rootView.setVisibility(View.INVISIBLE);
                realDismissDialog();
            }
        });
        // make the view visible and start the animation
        rootView.setVisibility(View.VISIBLE);
        circularReveal.start();

        int additionalDelay = 0;
        for (final View button : buttons) {
            button.animate().scaleX(0).scaleY(0).setStartDelay(additionalDelay).setDuration(BUTTON_REVEAL_ANIM_LENGTH).start();
            additionalDelay += (BUTTON_REVEAL_ANIM_LENGTH * 0.4);
        }
    }


}
