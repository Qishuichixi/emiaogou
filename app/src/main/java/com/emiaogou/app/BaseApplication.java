package com.emiaogou.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;

import com.emiaogou.R;

import java.util.concurrent.TimeUnit;

/**
 * QQ:798150439
 * TEL:18770813363
 * Email:qishuichixi@163.com
 * Created by zhou on 2017/11/13
 * PACKAGE_NAME:com.emiaogou.app
 * PROJECT_NAME:emiaogou
 * Desc:
 */

public class BaseApplication extends Application {
    private static BaseApplication application;
    private static int mainTid;
    private static Handler handler;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }


    @Override
//  在主线程运行的
    public void onCreate() {
        super.onCreate();
        application = this;
        mainTid = android.os.Process.myTid();
        handler = new Handler();

    }

    public static Context getApplication() {
        return application;
    }

    public static int getMainTid() {
        return mainTid;
    }

    public static Handler getHandler() {
        return handler;
    }


}
