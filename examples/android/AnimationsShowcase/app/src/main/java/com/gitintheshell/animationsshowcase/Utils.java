package com.gitintheshell.animationsshowcase;

import android.content.Context;
import android.util.DisplayMetrics;

import static java.security.AccessController.getContext;

/**
 * Created by Semyon on 04.06.2017.
 */

public class Utils {

    public static int dpToPx(final Context context, final int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int pxToDp(final Context context, final int px) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

}
