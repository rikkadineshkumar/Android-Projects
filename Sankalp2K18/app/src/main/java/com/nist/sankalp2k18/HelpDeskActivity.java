package com.nist.sankalp2k18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HelpDeskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_desk);
        getSupportActionBar().hide();
    }
}