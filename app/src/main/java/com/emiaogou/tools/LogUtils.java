package com.emiaogou.tools;

import android.util.Log;

/**
 * QQ:798150439
 * TEL:18770813363
 * Email:qishuichixi@163.com
 * Created by zhou on 2017/11/13
 * PACKAGE_NAME:com.emiaogou.tools
 * PROJECT_NAME:emiaogou
 * Desc:
 */

public class LogUtils {

    /**
     * 日志输出时的TAG
     */
    private static String mTag = "QISHUIJIANDI";

    private static Boolean flag = true;//调试时打开，发布时设置关闭，提高性能

    public static void setDebug(Boolean flag) {
        LogUtils.flag = flag;
    }

    public static void w(Object msg) {

        if (flag)
            Log.w(mTag, "" + msg);

    }

    public static void i(Object msg) {

        if (flag)
            Log.i(mTag, "" + msg);

    }

    public static void d(Object msg) {

        if (flag)
            Log.d(mTag, "" + msg);

    }

    public static void e(Object msg) {

        if (flag)
            Log.e(mTag, "" + msg);

    }


}
