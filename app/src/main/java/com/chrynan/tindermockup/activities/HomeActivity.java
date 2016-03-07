package com.chrynan.tindermockup.activities;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.chrynan.tindermockup.R;
import com.chrynan.tindermockup.fragments.CardFragment;
import com.chrynan.tindermockup.fragments.MatchFragment;

/**
 * Created by chRyNaN on 3/6/2016.
 */
public class HomeActivity extends AppCompatActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private View headerView;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    @SuppressWarnings("deprecation")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(false);
                drawerLayout.closeDrawers();
                //Add logic to perform the appropriate action depending on what item was selected
                switch(menuItem.getItemId()){
                    case R.id.discover_settings:
                        return true;
                    case R.id.app_settings:
                        return true;
                    case R.id.help:
                        return true;
                    case R.id.feedback:
                        return true;
                    case R.id.tinder_plus:
                        return true;
                }
                return false;
            }
        });
        headerView = LayoutInflater.from(this).inflate(R.layout.navigation_header, navigationView, false);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Load the Users profile
            }
        });
        navigationView.addHeaderView(headerView);
        //TODO Add logic to display the users information into the header view
        drawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,         /* DrawerLayout object */
                toolbar,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {
            /**
             * Called when a drawer has settled in a completely closed state.
             */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            /**
             * Called when a drawer has settled in a completely open state.
             */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        // Set the drawer toggle as the DrawerListener
        drawerLayout.addDrawerListener(drawerToggle);
        //Set up the tabs and swipeable views
        viewPager = (ViewPager) findViewById(R.id.pager);
        ScreenSlidePagerAdapter adapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        tabLayout = (TabLayout) toolbar.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        //Set up the icons
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            switch(i){
                default:
                case 0:
                    tabLayout.getTabAt(i).setIcon(R.drawable.tinder_icon);
                    break;
                case 1:
                    tabLayout.getTabAt(i).setIcon(R.drawable.speech_bubbles_gray);
                    break;
            }
        }
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }


    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
        private Context context;

        public ScreenSlidePagerAdapter(FragmentManager fm, Context context){
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                default:
                case 0:
                    return CardFragment.newInstance();
                case 1:
                    return MatchFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
           return "";
        }

    }


}
