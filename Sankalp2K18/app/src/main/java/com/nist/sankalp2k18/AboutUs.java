package com.nist.sankalp2k18;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class AboutUs extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().hide();

        ImageButton abhi_in=(ImageButton)findViewById(R.id.abhi_linkedin);
        ImageButton abhi_fb=(ImageButton)findViewById(R.id.abhi_fb);
        ImageButton abhi_gmail=(ImageButton)findViewById(R.id.abhi_google);

        ImageButton dinu_in=(ImageButton)findViewById(R.id.dinu_linkedin);
        ImageButton dinu_fb=(ImageButton)findViewById(R.id.dinu_fb);
        ImageButton dinu_gmail=(ImageButton)findViewById(R.id.dinu_google);

        abhi_in.setOnClickListener(this);
        abhi_fb.setOnClickListener(this);
        abhi_gmail.setOnClickListener(this);

        dinu_in.setOnClickListener(this);
        dinu_fb.setOnClickListener(this);
        dinu_gmail.setOnClickListener(this);
        /*startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/abhishek-kumar-soni-abhi18611/")));*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.abhi_linkedin:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/abhishek-kumar-soni-abhi18611/")));
                break;
            case R.id.abhi_fb:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/abhishek.kumarsoni.5/")));
                break;
            case R.id.abhi_google:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "abhisheksoni0071@gmail.com")));
                break;
            case R.id.dinu_linkedin:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/rikkadineshkumar/")));
                break;
            case R.id.dinu_fb:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/danial.deffo")));
                break;
            case R.id.dinu_google:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "Danialdinesh333@gmail.com")));
                break;
        }
    }
}
