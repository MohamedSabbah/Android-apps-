package com.sqlite.sab.facebook.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sqlite.sab.facebook.R;
import com.sqlite.sab.facebook.adapter.PagerCusomAdapter;

public class FaceBookActivty extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    PagerCusomAdapter pagerCusomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_book_activty);
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("tab2"));

        viewPager = findViewById(R.id.viewpager);

        pagerCusomAdapter = new PagerCusomAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerCusomAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}
