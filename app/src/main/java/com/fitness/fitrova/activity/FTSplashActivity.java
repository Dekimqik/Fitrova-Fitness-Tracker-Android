package com.fitness.fitrova.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.fitness.fitrova.R;
import com.fitness.fitrova.application.FTApp;

public class FTSplashActivity extends FTBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftsplash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goFirst();
            }
        }, 2000);
    }

    private void goFirst() {

        Intent intent = new Intent(FTSplashActivity.this, FTLoginActivity.class);
        startActivity(intent);
        finishWithoutAnimation();

        if (FTApp.userInfo == null) {
//            Intent intent = new Intent(FTSplashActivity.this, CIFirstActivity.class);
//            startActivity(intent);
//            finishWithoutAnimation();
        } else {
//            Intent intent = new Intent(FTSplashActivity.this, CIMainActivity.class);
//            startActivity(intent);
//            finishWithoutAnimation();
        }
    }
}
