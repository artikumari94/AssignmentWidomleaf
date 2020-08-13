package com.wisdomleaf.assignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.wisdomleaf.assignment.R;

public class SplashScreen extends AppCompatActivity {
    private static final int SPLASH_DURATION = 5000;
    private Handler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        myHandler = new Handler();
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                    startActivity(new Intent(SplashScreen.this,
                            MainActivity.class));

            }
        }, SPLASH_DURATION);
    }
}
