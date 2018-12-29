package com.nist.sankalp2k18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_scrolling);
        Intent i=getIntent();

        ImageView imageView=(ImageView)findViewById(R.id.event_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textView=(TextView)findViewById(R.id.desc);

        imageView.setBackgroundResource(i.getIntExtra("img",0));
        toolbar.setTitle(i.getCharSequenceExtra("txt"));
        textView.setText(getResources().getString(i.getIntExtra("desc",0)));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
