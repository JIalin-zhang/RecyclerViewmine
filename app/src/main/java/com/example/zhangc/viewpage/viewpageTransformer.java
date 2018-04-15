package com.example.zhangc.viewpage;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by zhangjl on 2018/4/15.
 */

public class viewpageTransformer implements ViewPager.PageTransformer {

    private float touming  = 0.5f;
    /**
     * position 取值特点是
     * 假设是0~1
     * 第一个页面的position变化是【0，-1】
     * 第二个页面的position变化是【1，0】
     * @param page
     * @param position
     */

    @Override
    public void transformPage(View page, float position) {
        if (position<-1||position>1){
            page.setAlpha(touming);
        }else {
            if (position<0){
                page.setAlpha(touming+(1+position)*(1-touming));
            }else {
                page.setAlpha(touming+(1-position)*(1-touming));
            }

        }
    }
}
