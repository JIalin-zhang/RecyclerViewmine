package com.example.zhangc.recyclerviewmine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zhangc on 18/4/11.
 */

public class ItemDecoration extends RecyclerView.ItemDecoration {
     private Paint mPaint;

    public ItemDecoration() {
        super();
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
    }

    /**
     * 绘制偏移量上空白内容内容，若与item重叠会被item上的内容覆盖
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        //获取item的个数
        final int childCount = parent.getChildCount();
        // 设置布局参数
        for(int i = 0;i<childCount;i++){
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int mDivider = 50;

            //找出分割线（矩形）的左上点和右下点
            //item 的左边坐标
            final int left = parent.getPaddingLeft();
            // ItemView的下边界：ItemView 的 bottom坐标 + 距离RecyclerView底部距离（padding值） +translationY
            final int top = child.getBottom()+params.bottomMargin;
            // ItemView的右边界 = RecyclerView 的右边界减去 paddingRight 后的坐标位置
            final int right = parent.getWidth();
            // 绘制分割线的下边界 = ItemView的下边界+分割线的高度
            final int bottom = top + mDivider;
            // 通过Canvas绘制矩形（分割线）
            c.drawRect(left,top,right,bottom,mPaint);
        }



    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    /**
     * 设置ItemView的内嵌偏移长度
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.set(0, 0, 0,50);


    }
}
