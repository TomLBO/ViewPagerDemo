package com.bob.tabhosttest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;


import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bob on 2016/4/25.
 */
public class ThirdActivity extends Activity {
    private static final String TAG = "ThirdActivity";

    private ViewPager viewPager;
    private TabPageIndicator indicator;
    private List<View> views;
    private List<String> titles;
    private int selectedColor;
    private int normalColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);

        initData();

        initView();
    }

    private void initData() {
        views = new ArrayList<>();
        View view1 = View.inflate(this, R.layout.layout_1, null);
        View view2 = View.inflate(this, R.layout.layout_2, null);
        View view3 = View.inflate(this, R.layout.layout_3, null);
        View view4 = View.inflate(this, R.layout.layout_4, null);
        View view5 = View.inflate(this, R.layout.layout_5, null);
        View view6 = View.inflate(this, R.layout.layout_6, null);
        View view11 = View.inflate(this, R.layout.layout_1, null);
        View view22 = View.inflate(this, R.layout.layout_2, null);
        View view33 = View.inflate(this, R.layout.layout_3, null);
        View view44 = View.inflate(this, R.layout.layout_4, null);
        View view55 = View.inflate(this, R.layout.layout_5, null);
        View view66 = View.inflate(this, R.layout.layout_6, null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);
        views.add(view6);
        views.add(view11);
        views.add(view22);
        views.add(view33);
        views.add(view44);
        views.add(view55);
        views.add(view66);

        titles = new ArrayList<>();
        titles.add("view1");
        titles.add("view2");
        titles.add("view3");
        titles.add("view4");
        titles.add("view5");
        titles.add("view6");
        titles.add("view11");
        titles.add("view22");
        titles.add("view33");
        titles.add("view44");
        titles.add("view55");
        titles.add("view66");

    }


    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        indicator = (TabPageIndicator) findViewById(R.id.indicator);

        viewPager.setAdapter(new ContentViewPagerAdapter());
        indicator.setViewPager(viewPager);
//        indicator.setCurrentItem(0);

        selectedColor = this.getResources().getColor(R.color.colorAccent);
        normalColor = getResources().getColor(R.color.colorPrimary);

        indicator.setSelectedTabBg(0, normalColor, selectedColor);
        indicator.setOnPageChangeListener(new PagerChangerListener());
    }

    class ContentViewPagerAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = views.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

    class PagerChangerListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            /*
                position                当前显示的布局坐标,positionOffset,positionOffsetPixels两个参数描述的目标
                positionOffset          从左往右划的百分比0-1
                positionOffsetPixels    像素数 从左往右 0-max
             */
//            Log.i(TAG, "onPageScrolled: postion = " + position);//当前显示的布局坐标,positionOffset,positionOffsetPixels两个参数描述的目标
//            Log.i(TAG, "onPageScrolled: positionOffset = " + positionOffset);//从左往右划的百分比0-1,
//            Log.i(TAG, "onPageScrolled: positionOffsetPixels = " + positionOffsetPixels);//像素数 从左往右 0-max


        }

        @Override
        public void onPageSelected(int position) {
            //position  当前显示的坐标
//            Log.i(TAG, "onPageSelected: position = " + position);

            indicator.setSelectedTabBg(position, normalColor, selectedColor);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            /*
                state   监听当前viewpager状态
                1 手指滑动(刚按下不滑动时不会回调此方法)
                2 手指拿起
                0 滑动完成
             */

//            Log.i(TAG, "onPageScrollStateChanged: state = " + state);
        }
    }
}
