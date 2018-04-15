package com.example.zhangc.viewpage;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by zhangjl on 2018/4/15.
 */

public class viewpageAdpater extends PagerAdapter{
    private Context context;
    private ViewPager viewPager;
    private int[] pic;

    public viewpageAdpater (Context context, ViewPager viewPager, int[] pic){
        this.context = context;
        this.viewPager = viewPager;
        this.pic =pic;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView= new ImageView(context);
        imageView.setImageResource(pic[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public int getCount() {
        return pic.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view ==object ;
    }
}
