package com.nist.sankalp2k18;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Types.BoomType;
import com.nightonke.boommenu.Types.ButtonType;
import com.nightonke.boommenu.Types.PlaceType;
import com.nightonke.boommenu.Util;
import com.nist.sankalp2k18.Fragments.Events;
import com.nist.sankalp2k18.Fragments.Gallery;
import com.nist.sankalp2k18.Fragments.Home;
import com.nist.sankalp2k18.Fragments.OfficeBearers;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private BoomMenuButton boomMenuButtonInActionBar,boomInfo;
    BottomBar bottomBar;
    private View customView;
    TextView titleTextView;
    Context context;
    private boolean isInit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context=this;

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater inflater = LayoutInflater.from(this);
        customView = inflater.inflate(R.layout.custom_actionbar, null);
        titleTextView = (TextView) customView.findViewById(R.id.title_text);
        titleTextView.setText(R.string.app_name);

        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);

        boomInfo = (BoomMenuButton)customView.findViewById(R.id.info);
        bottomBar = (BottomBar)findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if(tabId==R.id.b_home){
                    Home home=new Home();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,home).commit();

                }
                else if(tabId==R.id.b_events) {
                    Events events=new Events();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,events).commit();

                }
                else if(tabId==R.id.b_office) {
                    OfficeBearers officeBearers=new OfficeBearers();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,officeBearers).commit();

                }
                else if(tabId==R.id.b_gallery) {
                    Gallery gallery=new Gallery();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,gallery).commit();

                }
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
            }
        });
    }

    private void initInfoBoom() {
        Drawable[] drawables = new Drawable[3];
        int[] drawablesResource = new int[]{
                R.drawable.feedback,
                R.drawable.faq,
                R.drawable.aboutus
        };
        for (int i = 0; i < 3; i++)
            drawables[i] = ContextCompat.getDrawable(context, drawablesResource[i]);

        int[][] colors = new int[3][2];
        for (int i = 0; i < 3; i++) {
            colors[i][1] = ContextCompat.getColor(context, R.color.colorBoomButton);
            colors[i][0] = Util.getInstance().getPressedColor(colors[i][1]);
        }

        // Now with Builder, you can init BMB more convenient
        new BoomMenuButton.Builder()
                .subButtons(drawables, colors, new String[]{"Feedback","Help Desk","AboutUs"})
                .button(ButtonType.HAM)
                .boom(BoomType.PARABOLA_2)
                .place(PlaceType.HAM_3_1)
                .subButtonsShadow(Util.getInstance().dp2px(2), Util.getInstance().dp2px(2))
                .subButtonTextColor(ContextCompat.getColor(context, R.color.colorBoomButton))
                .onSubButtonClick(new BoomMenuButton.OnSubButtonClickListener() {
                    @Override
                    public void onClick(int buttonIndex) {
                        if (buttonIndex == 0) {
                            Intent i=new Intent(getApplicationContext(),FeedbackActivity.class);
                            startActivity(i);
                        } else if (buttonIndex == 1) {
                            Intent i=new Intent(getApplicationContext(),HelpDeskActivity.class);
                            startActivity(i);
                        }else if (buttonIndex == 2) {
                            Intent i=new Intent(getApplicationContext(),AboutUs.class);
                            startActivity(i);
                        }
                    }
                })
                .init(boomInfo);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!isInit) {
            //initBoom();
            initInfoBoom();
        }
        isInit = true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
