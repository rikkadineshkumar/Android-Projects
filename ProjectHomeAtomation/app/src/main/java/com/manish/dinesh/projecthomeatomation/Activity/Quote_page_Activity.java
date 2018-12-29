package com.manish.dinesh.projecthomeatomation.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.manish.dinesh.projecthomeatomation.R;

public class Quote_page_Activity extends AppCompatActivity {

    ImageView mImageView_signin, mImageView_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_page);

        mImageView_signin = (ImageView) findViewById(R.id.quote_page_signin_imageview);
        mImageView_register = (ImageView) findViewById(R.id.quote_page_register_imageview);

        mImageView_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        mImageView_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),Register_Activity.class));
            }
        });
    }
}
