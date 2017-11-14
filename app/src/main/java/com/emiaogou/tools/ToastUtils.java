package com.emiaogou.tools;

import android.content.Context;
import android.widget.Toast;

/**
 * QQ:798150439
 * TEL:18770813363
 * Email:qishuichixi@163.com
 * Created by zhou on 2017/11/13
 * PACKAGE_NAME:com.emiaogou.tools
 * PROJECT_NAME:emiaogou
 * Desc:
 */

public class ToastUtils {

    private static Toast mToast;
    private static Toast mToastShort;
    private static Context context=UiUtils.getContext();

    public static void show( String msg) {

        if (mToast == null)
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        else
            mToast.setText(msg);

        mToast.show();
    }


    public static void showLong( String msg) {

        if (mToastShort == null)
            mToastShort = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        else
            mToastShort.setText(msg);

        mToastShort.show();
    }

}
