package com.example.nawaf.myapp2;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentDesign extends AppCompatActivity {
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        mViewPager = (ViewPager) findViewById(R.id.activity_fragment);
        TitleAdapter titleAdapter = new TitleAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(titleAdapter);


    }
}
