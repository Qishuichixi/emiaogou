package com.emiaogou.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import java.util.LinkedList;
import java.util.List;

/**
 * 作者：Created by zhou
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：作为所用activity的基类
 */

public abstract  class BaseActivity extends AppCompatActivity {

    // 管理运行的所有的activity
    public final static List<BaseActivity> mActivities = new LinkedList<BaseActivity>();

    public static BaseActivity activity;

    @Override
    protected void onResume() {
        super.onResume();
        activity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        activity = null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置屏幕方向
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        synchronized (mActivities) {
            mActivities.add(this);
        }

        setContentView( initViews());
        initEvent();

    }

    protected void initEvent() {
    }

    protected abstract int initViews() ;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivities) {
            mActivities.remove(this);
        }
    }

    public static void killAll() {
        // 复制了一份mActivities 集合
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new LinkedList<BaseActivity>(mActivities);
        }
        for (BaseActivity activity : copy) {
            activity.finish();
        }
        // 杀死当前的进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
