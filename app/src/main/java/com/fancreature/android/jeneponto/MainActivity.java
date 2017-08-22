package com.fancreature.android.jeneponto;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.fancreature.android.jeneponto.Activity.Bahasa;
import com.fancreature.android.jeneponto.Activity.Beranda;
import com.fancreature.android.jeneponto.Activity.Hubungi;
import com.fancreature.android.jeneponto.Activity.Investasi;
import com.fancreature.android.jeneponto.Activity.Kalkulator;
import com.fancreature.android.jeneponto.Activity.Keluhan;
import com.fancreature.android.jeneponto.Activity.Perizinan;
import com.fancreature.android.jeneponto.Activity.Sample;
import com.fancreature.android.jeneponto.Activity.Something;
import com.fancreature.android.jeneponto.Activity.Tracking;
import com.fancreature.android.jeneponto.Activity.Wisata;

/**
 * Created by Irfan Assidiq on 7/26/2017.
 */

public class MainActivity extends AppCompatActivity{
    private DrawerLayout mdrawer;
    private Toolbar toolbar;
    private NavigationView nVDrawer;
    private Class FragmentClass;
    private ActionBarDrawerToggle drawerToggle;
    FragmentManager fragmentManager;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //set Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //find drawerView
        mdrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();

        //set nav drawer
        nVDrawer = (NavigationView) findViewById(R.id.nView);
        setupDrawerContent(nVDrawer);

        if (savedInstanceState == null) {
            fragment = new Beranda();
            callFragment(fragment);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        drawerToggle.syncState();
    }

    //this one is used for popup dialog
    public void Sdialog() {
        AlertDialog mDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.fitur)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("MyTag", "Click YES");
                            }
                        })
                .create();

        mDialog.show();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if (FragmentClass == Beranda.class){
        AlertDialog mDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.sure)
                .setPositiveButton(R.string.yes,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("MyTag", "Click Ya");
                                System.exit(0);
//                                    onDestroy();
                            }

                        })
                .setNegativeButton(R.string.no,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("MyTag", "Click Tidak");

                            }

                        })
                .create();

        mDialog.show();
    }
        else{
            FragmentClass = Beranda.class;
            try {
                fragment = (Fragment) FragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            FragmentManager fragmentmanager = getSupportFragmentManager();
            fragmentmanager.beginTransaction().replace(R.id.fContent, fragment, "My Tag").commit();
            setTitle(super.getTitle());
             mdrawer.closeDrawers();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        drawerToggle.onConfigurationChanged(newConfig);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mdrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        switch (item.getItemId()){
//            case android.R.id.home:
//                mdrawer.openDrawer(GravityCompat.START);
//        }
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener(){
                public boolean onNavigationItemSelected(MenuItem menuitem) {
                    selectDrawerItem(menuitem);
                    return true;
                }
            });
         }

    private void selectDrawerItem(MenuItem menuitem) {

        switch (menuitem.getItemId()){
            case R.id.nav_satu:
                FragmentClass = Beranda.class;
//                getTitle();
                break;
            case R.id.nav_dua :
                   FragmentClass = Wisata.class;
//                getTitle();
                break;
            case R.id.nav_tiga:
                FragmentClass = Investasi.class;
//                getTitle();
                break;
            case R.id.nav_empat:
//                Sdialog();
//                FragmentClass = Beranda.class;
                FragmentClass = Perizinan.class;
                break;
            case R.id.nav_lima:
                FragmentClass = Something.class;
                break;
            case R.id.nav_enam:
                FragmentClass = Tracking.class;
                break;
            case R.id.nav_tujuh:
                FragmentClass = Kalkulator.class;
//                FragmentClass = Sample.class;
//                fragment = new Sample();
                break;

            case R.id.nav_delapan:
                FragmentClass = Keluhan.class;
                break;
            case R.id.nav_sembilan:
                FragmentClass = Hubungi.class;
                break;
//            case R.id.nav_sepuluh:
//                Sdialog();
//                FragmentClass = Beranda.class;
////                 FragmentClass = Bahasa.class;

//                break;
            default:
                FragmentClass = Hubungi.class;
        }
        try {
            fragment = (Fragment) FragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentmanager = getSupportFragmentManager();
        fragmentmanager.beginTransaction().replace(R.id.fContent, fragment, "My Tag").commit();

        menuitem.setChecked(true);
        //set action bar title
//        setTitle(menuitem.getTitle());


        mdrawer.closeDrawers();
    }
    private void callFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fContent, fragment)
                .commit();
    }
}

