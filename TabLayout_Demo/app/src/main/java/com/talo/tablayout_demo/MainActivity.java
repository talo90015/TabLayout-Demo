package com.talo.tablayout_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InnerPagerAdapter pagerAdapter = new InnerPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewPage);
        viewPager.setAdapter(pagerAdapter);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        getSupportActionBar().hide();


    }
    public class  InnerPagerAdapter extends FragmentPagerAdapter {
        public InnerPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        //依照目前case編號，傳回對應fragment
        @NonNull
        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;
            switch (position){
                case 0:
                    fragment = new FirstFragment();
                    Toast.makeText(MainActivity.this, "First Fragment", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    fragment = new SecondFragment();
                    Toast.makeText(MainActivity.this, "Second Fragment", Toast.LENGTH_SHORT).show();
                    break;
            }
            return fragment;
        }

        //傳回頁面總數
        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "First Fragment";
                case 1:
                    return "Second Fragment";
                default:
                    return null;
            }
        }
    }
}