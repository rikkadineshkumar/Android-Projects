package com.manish.dinesh.projecthomeatomation.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.manish.dinesh.projecthomeatomation.Dialogs.AddDeviceDialog;
import com.manish.dinesh.projecthomeatomation.Fragment.AboutFragment;
import com.manish.dinesh.projecthomeatomation.Fragment.QRCodeFragment;
import com.manish.dinesh.projecthomeatomation.Fragment.SettingFragments;
import com.manish.dinesh.projecthomeatomation.Fragment.ShareFragment;
import com.manish.dinesh.projecthomeatomation.Fragment.consoleFragment;
import com.manish.dinesh.projecthomeatomation.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uid = getIntent().getStringExtra("user_id");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        consoleFragment fragment = new consoleFragment();
        Bundle args = new Bundle();//for fragments to pass data
        args.putString("uid",uid);//for fragments to pass the Arduino id
        fragment.setArguments(args);
        fragmentTransaction.replace(R.id.main_content,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Bundle args = new Bundle();//for fragments to pass data
        args.putString("uid",uid);//for fragments to pass the Arduino id

        if (id == R.id.nav_dashboard) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            consoleFragment fragment = new consoleFragment();
            fragment.setArguments(args);
            fragmentTransaction.replace(R.id.main_content,fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_qr_code) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            QRCodeFragment fragment = new QRCodeFragment();
            fragment.setArguments(args);
            fragmentTransaction.replace(R.id.main_content,fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_manage) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            SettingFragments fragment = new SettingFragments();
            fragment.setArguments(args);
            fragmentTransaction.replace(R.id.main_content,fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_share) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            ShareFragment fragment = new ShareFragment();
            fragment.setArguments(args);
            fragmentTransaction.replace(R.id.main_content,fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_about) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            AboutFragment fragment = new AboutFragment();
            fragment.setArguments(args);
            fragmentTransaction.replace(R.id.main_content,fragment);
            fragmentTransaction.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}