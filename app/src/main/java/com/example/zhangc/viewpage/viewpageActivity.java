package com.example.zhangc.viewpage;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.example.zhangc.recyclerviewmine.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhangjl on 2018/4/15.
 */

public class viewpageActivity extends Activity {
    @Bind(R.id.viewPage)
    ViewPager viewPage;
    private int [] images;
    private viewpageAdpater viewpagerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpage);
        ButterKnife.bind(this);
        images = new int[]{R.mipmap.bizhi,R.mipmap.me,R.mipmap.pic};
        viewpagerAdapter = new viewpageAdpater(this,viewPage,images);
        viewPage.setAdapter(viewpagerAdapter);
        viewPage.setPageMargin(80);
        viewPage.setOffscreenPageLimit(3);


    }
}
