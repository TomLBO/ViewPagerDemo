package com.bob.tabhosttest;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends ActivityGroup {

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (TabHost) findViewById(android.R.id.tabhost);

        tabHost.setup(this.getLocalActivityManager());

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("tab 1").setContent(new Intent(this, FirstActivity.class)) );
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("tab 2").setContent(new Intent(this, SecondActivity.class)) );
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("tab 3").setContent(new Intent(this, ThirdActivity.class)) );



    }
}
