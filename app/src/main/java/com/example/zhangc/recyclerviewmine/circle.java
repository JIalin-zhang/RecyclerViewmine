package com.example.zhangc.recyclerviewmine;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhangc on 18/4/13.
 */

public class circle extends Activity {

    @Bind(R.id.circle)
    circlemine circle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circlelayout);
        ButterKnife.bind(this);
        circle.setProgress(60,true);

    }
}
