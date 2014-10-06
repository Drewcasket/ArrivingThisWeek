package com.arrivingthisweek;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;


public class MainActivity extends FragmentActivity {

    ViewPager viewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
    }

        class MyAdapter extends FragmentStatePagerAdapter {

            public MyAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int i) {
                Fragment fragment = null;
                if (i == 0) {
                    fragment = new PublishersFragment();
                }
                if (i == 1) {
                    fragment = new FavoritesFragment();
                }
                if (i == 2) {
                    fragment = new SearchFragment();
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                String title = new String();
                if (position == 0) {
                    return "Publishers";
                }
                if (position == 1) {
                    return "Favorites";
                }
                if (position == 2) {
                    return "Search";
                }
                return super.getPageTitle(position);
            }

        }
    }
