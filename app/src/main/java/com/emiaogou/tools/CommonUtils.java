package com.emiaogou.tools;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.telecom.Call;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.emiaogou.R;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * QQ:798150439
 * TEL:18770813363
 * Email:qishuichixi@163.com
 * Created by zhou on 2017/11/13
 * PACKAGE_NAME:com.emiaogou.tools
 * PROJECT_NAME:emiaogou
 * Desc:
 */

public class CommonUtils {

    public static <T extends View> T f(Activity activity, int id) {


        return (T) activity.findViewById(id);

    }

    public static <T extends View> T f(View view, int id) {

        return (T) view.findViewById(id);

    }


    //获取组件文本
    public static String getText(EditText et) {

        return StringUtils.toString(et.getText().toString().trim());
    }

    public static String getText(TextView tv) {

        return StringUtils.toString(tv.getText().toString().trim());
    }


    //设置下划线

    public static void setTextUnderline(TextView tv) {
        tv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        tv.getPaint().setAntiAlias(true);//抗锯齿
    }

    //删除线
    public static void setTextDeleteline(TextView tv) {
        tv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); //删除线
        tv.getPaint().setAntiAlias(true);//抗锯齿
    }

    //将光标移至文字末尾
    public static void moveLast(EditText editText) {

        int pos = editText.getText().toString().length();
        editText.setSelection(pos);
    }

    //设置带星号的手机号
    public static String setPhone(String phone) {
        if (phone == null) return "";
        if (phone != null && phone.length() < 11) return "";
        return phone.substring(0, 3) + "****" + phone.substring(7, 11);
    }

    //拨打电话
    public static void dial(String tel) {
        // 跳转到拨号界面
        Intent intent = new Intent();
        intent.setAction("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + tel));
        UiUtils.startActivity(intent);
    }


    public static String getTime(long time, String format) {
        SimpleDateFormat simpleDateFormat = null;
        if (format == null) {
            simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        } else {
            simpleDateFormat = new SimpleDateFormat(format);
        }

        String date = simpleDateFormat.format(new Date(time));
        return date;
    }

    /**
     * 时间差
     *
     * @param t1
     * @return
     */
    public static String getTimeDifference(long t1) {


        long s = (System.currentTimeMillis() - t1) / 1000;

        String result = "";

        if (s < 60) {

            //1 min
            result = StringUtils.toString(s + "秒");

        } else if (s < 3600) {
            //1 h
            //  result = StringUtils.addString(s / 60, "分钟", s % 60, "秒");
            result = StringUtils.addString(s / 60, "分钟");

        } else {

            int hour = (int) (s / 3600);
            int min = (int) (s % 3600 / 60);
            int second = (int) (s % 60);

            // result = StringUtils.addString(hour, "小时", min, "分钟", second, "秒");
            result = StringUtils.addString(hour, "小时");

        }

        return result;

    }


    //设置透明度
    public static void setAlpha(Activity activity, int alpha) {
        WindowManager.LayoutParams windowLP = activity.getWindow().getAttributes();
        windowLP.alpha = (float) (alpha / 100.0);
        activity.getWindow().setAttributes(windowLP);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }


    //保持常亮

    public static void keepLight(Activity activity) {

        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }


    /**
     * 适配对于低于19版本的手机
     *
     * @param v
     * @param activity
     */
    public static void setTopRl(View v, Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) v.getLayoutParams();
            lp.height = StatusBarUtils.getStatusBarHeight(activity);
            v.setLayoutParams(lp);
        } else {
            v.setVisibility(View.GONE);
        }

    }

    public static void setTop(View v, Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) v.getLayoutParams();
            lp.height = StatusBarUtils.getStatusBarHeight(activity);
            v.setLayoutParams(lp);
        } else {
            v.setVisibility(View.GONE);
        }

    }

    /**
     * 设置搜索关键字高亮
     *
     * @param content 原文本内容
     * @param keyword 关键字
     */
    public static SpannableString setKeyWordColor(String content, String keyword) {
        SpannableString s = new SpannableString(content);
        Pattern p = Pattern.compile(keyword);
        Matcher m = p.matcher(s);
        while (m.find()) {
            int start = m.start();
            int end = m.end();
            s.setSpan(new ForegroundColorSpan(Color.RED), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return s;
    }

    /**
     * 打印map
     *
     * @param map
     */
    public static void outMap(Map<String, String> map) {
        //遍历map
        LogUtils.e("==================================请求参数===================================");
        for (String s : map.keySet()) {
            LogUtils.e(getTime(System.currentTimeMillis(), "HH:mm:ss") + "  key: " + s + "  value: " + map.get(s));
        }
        LogUtils.e("============================================================================");

    }


    private static CallBack callBack;

    public CommonUtils setCallBack(CallBack callBack) {
        this.callBack = callBack;
        return this;
    }

    public interface CallBack {
        void doSomeThing();
    }

    /**
     * 版本名
     */
    public static String getAppVersionName() {

        String packageName = UiUtils.getContext().getPackageName();

        try {
            PackageManager pm = UiUtils.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? "V2.0.0" : pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "V2.0.0";
        }
    }


    /**
     * 分割合并字符串
     */

    public static String getSplitResult(String r, String split) {

        if (r == null) return "";

        String[] list = r.split(split);
        String s = "";
        for (int i = 0; i < list.length; i++) {
            s = s + list[i];
        }
        return s;
    }


    /**
     * @param t
     * @return
     */
    public static String getFormatTime(long t) {

        String result = "";

        long sum = t / 1000; // s


        if (sum > 60 * 60) {
            //超过一小时  **小时**分钟**秒
            int hour = (int) (sum / 3600);
            int min = (int) ((sum % 3600) / 60);
            int sec = (int) (sum % 60);

            result = hour + "小时" + (min >= 10 ? "" + min : "0" + min) + "分钟" + (sec >= 10 ? "" + sec : "0" + sec) + "秒" + "###" + hour + "###" + (min >= 10 ? "" + min : "0" + min) + "###" + (sec >= 10 ? "" + sec : "0" + sec);

        } else if (sum > 60) {
            //超过一分钟  **分钟**秒

            int min = (int) (sum / 60);
            int sec = (int) (sum % 60);

            result = min + "分钟" + (sec >= 10 ? "" + sec : "0" + sec) + "秒" + "###00" + "###" + min + "###" + (sec >= 10 ? "" + sec : "0" + sec);

        } else {
            //不足60s
            result = (sum >= 10 ? "" + sum : "0" + sum) + "秒" + "###00" + "###00" + "###" + (sum >= 10 ? "" + sum : "0" + sum);
        }

        return result;
    }


    /**
     * 大数
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal getAddBigDecimal(Object a, Object b) {

        BigDecimal bigDecimalA = new BigDecimal(StringUtils.toString(a));
        BigDecimal bigDecimalB = new BigDecimal(StringUtils.toString(b));
        bigDecimalA = bigDecimalA.add(bigDecimalB);
        return bigDecimalA;

    }

    public static BigDecimal getSubBigDecimal(Object a, Object b) {

        BigDecimal bigDecimalA = new BigDecimal(StringUtils.toString(a));
        BigDecimal bigDecimalB = new BigDecimal(StringUtils.toString(b));
        bigDecimalA = bigDecimalA.subtract(bigDecimalB);
        return bigDecimalA;


    }

    public static BigDecimal getMulBigDecimal(Object a, Object b) {

        BigDecimal bigDecimalA = new BigDecimal(StringUtils.toString(a));
        BigDecimal bigDecimalB = new BigDecimal(StringUtils.toString(b));
        bigDecimalA = bigDecimalA.multiply(bigDecimalB);
        return bigDecimalA;


    }

    public static BigDecimal getDivBigDecimal(Object a, Object b) {

        BigDecimal bigDecimalA = new BigDecimal(StringUtils.toString(a));
        BigDecimal bigDecimalB = new BigDecimal(StringUtils.toString(b));
        bigDecimalA = bigDecimalA.divide(bigDecimalB);
        return bigDecimalA;
    }


    public static void setTheme(Activity activity){

        StatusBarUtils.setColor(activity,0xf94c24,1);
    }

}
