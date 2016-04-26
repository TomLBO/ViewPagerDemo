package com.bob.tabhosttest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bob on 2016/4/25.
 */
public class SecondActivity extends FragmentActivity implements View.OnClickListener {
    private ViewPager viewpager;

    private List<Fragment> fragments;
    private Button b1, b2, b3, b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initData();
        initView();
    }

    private void initData() {
        fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());


    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        b1 = (Button) findViewById(R.id.bt1);
        b2 = (Button) findViewById(R.id.bt2);
        b3 = (Button) findViewById(R.id.bt3);
        b4 = (Button) findViewById(R.id.bt4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
//        viewpager.setCurrentItem(1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                viewpager.setCurrentItem(0);
                break;
            case R.id.bt2:
                viewpager.setCurrentItem(1);
                break;
            case R.id.bt3:
                viewpager.setCurrentItem(2);
                break;
            case R.id.bt4:
                viewpager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    class FragmentAdapter extends FragmentPagerAdapter{


        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
