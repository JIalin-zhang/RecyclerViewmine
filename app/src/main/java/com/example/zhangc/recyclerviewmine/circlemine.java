package com.example.zhangc.recyclerviewmine;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.nfc.Tag;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

/**
 * Created by zhangc on 18/4/13.
 */

public class circlemine extends View{
    private Paint mPaint;//画圆弧的画笔
    private int firstcolor;//里层的颜色
    private int secondcolor ;//外层圆弧的颜色
    private int maxValue = 100;//进度条比例值
    private int curevalue = 40;//度条变化值
    private int circleWidth ;//圆环的宽度
    private float alphaAngle;//每次扫过的角度。用来设置进度条圆弧对应的圆心角 alphaAngle=（curevalue/maxValue）*360
    private Context context;
    private int [] colorArray = new int[] {Color.parseColor("#27B197"),Color.parseColor("#00A6D5") };
    public circlemine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        mPaint = new Paint();
        firstcolor = Color.YELLOW;
        secondcolor =Color.BLUE;
        circleWidth =dip2px(context,6);

        Log.e("111111","22222222");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centert = this.getWidth()/2;
        int radius = centert-circleWidth/2;
        drawCircle(canvas,centert,radius);

    }
    private void   drawCircle(Canvas canvas,int center,int radius){
        mPaint.setShader(null);
        mPaint.setColor(firstcolor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(circleWidth);//设置外边宽度
        canvas.drawCircle(center,center,radius,mPaint);
        //圆的外接正方形
        RectF oval = new RectF(center-radius,center-radius,center+radius,center+radius);

        LinearGradient linearGradient = new LinearGradient(circleWidth,circleWidth,getMeasuredWidth()-circleWidth,getMeasuredHeight()-circleWidth,colorArray,null, Shader.TileMode.MIRROR);
        mPaint.setShader(linearGradient);
        mPaint.setShadowLayer(10,10,10,Color.RED);
        mPaint.setColor(secondcolor);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        alphaAngle = curevalue * 360.0f /maxValue *1.0f;
        canvas.drawArc(oval,-90,alphaAngle,false,mPaint);

    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureHeight(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureHeight(int heightMeasureSpec) {
        // TODO Auto-generated method stub
        int result=0; //结果
        int specMode=MeasureSpec.getMode(heightMeasureSpec);
        int specSize=MeasureSpec.getSize(heightMeasureSpec);
        switch (specMode) {
            case MeasureSpec.AT_MOST:  // 子容器可以是声明大小内的任意大小
                Log.e("111", "子容器可以是声明大小内的任意大小");
                Log.e("111", "大小为:"+specSize);
                result=specSize;
                break;
            case MeasureSpec.EXACTLY: //父容器已经为子容器设置了尺寸,子容器应当服从这些边界,不论子容器想要多大的空间.  比如EditTextView中的DrawLeft
                Log.e("222", "父容器已经为子容器设置了尺寸,子容器应当服从这些边界,不论子容器想要多大的空间");
                Log.e("222", "大小为:"+specSize);
                result=specSize;
                break;
            case MeasureSpec.UNSPECIFIED:  //父容器对于子容器没有任何限制,子容器想要多大就多大. 所以完全取决于子view的大小
                Log.e("333", "父容器对于子容器没有任何限制,子容器想要多大就多大");
                Log.e("333", "大小为:"+specSize);
                result=1500;
                break;
            default:
                break;
        }
        return result;
    }
    /**
     * 按进度显示百分比，可选择是否启用数字动画
     *
     * @param progress
     *            进度，值通常为0到100
     * @param useAnimation
     *            是否启用动画，true为启用
     */
    public void setProgress(int progress, boolean useAnimation)
    {
        int percent = progress * maxValue / 100;
        if (percent < 0)
        {
            percent = 0;
        }
        if (percent > 100)
        {
            percent = 100;
        }
        if (useAnimation) // 使用动画
        {
            ValueAnimator animator = ValueAnimator.ofInt(0, percent);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
                @Override
                public void onAnimationUpdate(ValueAnimator animation)
                {
                    curevalue = (int) animation.getAnimatedValue();
                    invalidate();
                }
            });
            animator.setInterpolator(new OvershootInterpolator());
            animator.setDuration(1000);
            animator.start();
        }
        else
        {

        }
    }
    /**
     * 根据手机的分辨率PX(像素)转成DP
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
    /**
     * 根据手机分辨率从DP转成PX
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
