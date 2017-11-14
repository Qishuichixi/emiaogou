package com.emiaogou.activity;

import android.content.Intent;

import com.emiaogou.R;
import com.emiaogou.tools.StatusBarUtils;
import com.emiaogou.tools.UiUtils;

public class SplashActivity extends BaseActivity {

    @Override
    protected int initViews() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initEvent() {

        StatusBarUtils.darkMode(this);


        UiUtils.postDelayed(new Runnable() {
            @Override
            public void run() {

                UiUtils.startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();


            }
        },5000);


    }
}
