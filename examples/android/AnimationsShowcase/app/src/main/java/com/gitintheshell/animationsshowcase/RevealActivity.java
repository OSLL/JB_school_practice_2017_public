package com.gitintheshell.animationsshowcase;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class RevealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] location = new int[2];
                fab.getLocationOnScreen(location);
                final int radius = fab.getWidth() / 2;
                final NewEventModeSelector newEventModeSelector = new NewEventModeSelector(RevealActivity.this, new Point(location[0] + radius, location[1] + radius), radius);
                newEventModeSelector.show();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
