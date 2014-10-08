package com.arrivingthisweek;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    ViewPager viewPager=null;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_main);

        viewPager= (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                actionBar.setSelectedNavigationItem(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        actionBar=getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab publishersTab=actionBar.newTab();
        publishersTab.setText("Publishers");
        publishersTab.setTabListener(this);

        ActionBar.Tab favoritesTab=actionBar.newTab();
        favoritesTab.setText("Favorites");
        favoritesTab.setTabListener(this);

        ActionBar.Tab searchTab=actionBar.newTab();
        searchTab.setText("Search");
        searchTab.setTabListener(this);

        actionBar.addTab(publishersTab);
        actionBar.addTab(favoritesTab);
        actionBar.addTab(searchTab);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());


    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}

class MyAdapter extends FragmentStatePagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
        if(i==0) {
            fragment = new PublishersFragment();
        }
        if(i==1) {
            fragment=new FavoritesFragment();
        }
        if(i==2) {
            fragment=new SearchFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        String title=new String();
//        if(position==0) {
//            return "Publishers";
//        }
//        if(position==1) {
//            return "Favorites";
//        }
//        if(position==2) {
//            return "Search";
//        }
//        return super.getPageTitle(position);
//    }

}