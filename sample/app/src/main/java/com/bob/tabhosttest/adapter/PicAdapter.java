package com.bob.tabhosttest.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by bob on 2016/4/26.
 */
public class PicAdapter extends PagerAdapter {

    private List<View> list;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
