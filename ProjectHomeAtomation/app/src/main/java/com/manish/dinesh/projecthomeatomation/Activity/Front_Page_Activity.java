package com.manish.dinesh.projecthomeatomation.Activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.transition.Fade;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.manish.dinesh.projecthomeatomation.R;

public class Front_Page_Activity extends AppCompatActivity {

    private ViewGroup mViewGroup;
    private ImageView mImageView_header, mImageView_footer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        mViewGroup = (ViewGroup) findViewById(R.id.front_layout);
        mImageView_header = (ImageView) findViewById(R.id.imageView_front_header);
        mImageView_footer = (ImageView) findViewById(R.id.imageView_front_footer);

        new CountDownTimer(3000,1000){
           @Override
           public void onTick(long l) {
               //customAnimation(mImageView_header,mImageView_footer);
           }

           @Override
           public void onFinish() {
               startActivity(new Intent(getApplicationContext(),Quote_page_Activity.class));
               finish();
           }
        }.start();
    }



    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    void customAnimation(View...v){
        Fade fade = new Fade();
        fade.setDuration(3000);
        TransitionManager.beginDelayedTransition(mViewGroup,fade);

        for(View current : v){
            if(current.getVisibility() == View.VISIBLE)
                current.setVisibility(View.INVISIBLE);
        }

    }
}

