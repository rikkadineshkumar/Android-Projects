package com.nist.sankalp2k18;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sankalp_screen);

        getSupportActionBar().hide();

        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long l) {}

            @Override
            public void onFinish() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        }.start();
    }
}
