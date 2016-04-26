package com.bob.tabhosttest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bob on 2016/4/25.
 */
public class FirstActivity extends Activity {
    private LinearLayout container;
    private ViewPager viewPager;
//    private PagerTabStrip tabStrip;
    private List<View> views;
    private List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initData();
        initView();
    }

    private void initView() {
        container = (LinearLayout) findViewById(R.id.container);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
//        tabStrip = (PagerTabStrip) findViewById(R.id.tabStrip);
//        tabStrip.setDrawFullUnderline(false);
//        tabStrip.setBackgroundColor(this.getResources().getColor(R.color.colorAccent));
//        tabStrip.setTabIndicatorColor(this.getResources().getColor(R.color.colorPrimaryDark));
//        tabStrip.setTextSpacing(200);

        container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return viewPager.dispatchTouchEvent(event);
            }
        });
        viewPager.setOffscreenPageLimit(2);
        viewPager.setPageMargin(50);


        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
//                return views.size();
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                /*
                        0 % 4 0
                        1 % 4 1
                        2 % 4 2
                        3 % 4 4
                        4 & 4 0
                 */
//                View view = views.get(position % (views.size() + 1));
                View view = views.get(position % views.size());
//                if(container) {
//                    container.removeView(view)
//                }
//                ViewGroup parent = (ViewGroup) view.getParent();
//                if (parent != null) {
//                    parent.removeView(view);
//                }
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
//                super.destroyItem(container, position, object);
                container.removeView(views.get(position % views.size()));
            }

            @Override
            public CharSequence getPageTitle(int position) {

                return titles.get(position % views.size());
            }
        });


        viewPager.setCurrentItem(views.size() * 20);
    }

    private void initData() {
        views = new ArrayList<>();
        View view1 = View.inflate(this, R.layout.layout_1, null);
        View view2 = View.inflate(this, R.layout.layout_2, null);
        View view3 = View.inflate(this, R.layout.layout_3, null);
        View view4 = View.inflate(this, R.layout.layout_4, null);
        View view5 = View.inflate(this, R.layout.layout_5, null);
        View view6 = View.inflate(this, R.layout.layout_6, null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);
        views.add(view6);


        titles = new ArrayList<>();
        titles.add("view1");
        titles.add("view2");
        titles.add("view3");
        titles.add("view4");
        titles.add("view5");
    }
}
