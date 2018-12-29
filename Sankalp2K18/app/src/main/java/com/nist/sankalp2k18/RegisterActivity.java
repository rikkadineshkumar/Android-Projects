package com.nist.sankalp2k18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.nist.sankalp2k18.Fragments.NistianRegistration;
import com.nist.sankalp2k18.Fragments.OutsiderRegistration;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class RegisterActivity extends AppCompatActivity {

    private PrefManager prefManager;
    /*AlertDialog levelDialog;
    AlertDialog.Builder builder;
    // Strings to Show In Dialog with Radio Buttons
    final CharSequence[] items = {" NIST "," Visitor "};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //getSupportActionBar().hide();

        // One fragment will change by the parameter
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(FragmentPagerItem.of("nistians", NistianRegistration.class))
                .add(FragmentPagerItem.of("outsider", OutsiderRegistration.class))
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

        prefManager = new PrefManager(this);
        if (!prefManager.isUserRegistered()) {
            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

}


/*
builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you from NIST or a visitor ?");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                switch(item){
                    case 0:
                        Toast.makeText(getApplicationContext(), " From NIST ", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), " Visitor ", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                levelDialog.dismiss();
                //setContentView(R.layout.activity_register);
                //init();
            }
        });
        levelDialog = builder.create();
        levelDialog.show();

 */
