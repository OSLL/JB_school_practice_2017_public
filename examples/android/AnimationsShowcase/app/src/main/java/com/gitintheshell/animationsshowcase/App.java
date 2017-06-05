package com.gitintheshell.animationsshowcase;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

/**
 * Created by Semyon on 04.06.2017.
 */
@ReportsCrashes(formKey = "", // will not be used
        mailTo = "senya.danilov@gmail.com",
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_text)
public class App extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        ACRA.init(this);
    }
}
