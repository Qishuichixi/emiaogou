package com.emiaogou.tools;

/**
 * QQ:798150439
 * TEL:18770813363
 * Email:qishuichixi@163.com
 * Created by zhou on 2017/11/13
 * PACKAGE_NAME:com.emiaogou.tools
 * PROJECT_NAME:emiaogou
 * Desc:
 */
public class StringUtils {

    /**
     * 转成String
     *
     * @param object
     * @return
     */
    public static String toString(Object object) {

        return "" + object;
    }


    /**
     * 添加多个字符串
     *
     * @param object
     * @return
     */
    public static String addString(Object... object) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < object.length; i++) {
            sb.append(object[i]);
        }

        return "" + sb.toString();
    }

    /**
     * 判断是否为空
     *
     * @param result
     * @return
     */
    public static boolean isEmpty(String result) {

        if (result == null || "".equals(result)) {
            return true;
        }
        return false;
    }


    public static String romoveSpace(String result) {

        String re = result.replaceAll(" ", "");
        return re;
    }

    /**
     * 将 string 转成 int
     *
     * @param value
     * @return
     */
    public static Integer toInteger(String value) {

        if (isEmpty(value)) return 0;

        int v = 0;

        try {
            v = Integer.valueOf(value);

        } catch (Exception e) {

            LogUtils.e("转化异常:" + e);
        }


        return v;

    }

    /**
     * 将字符转成double
     *
     * @param value
     * @return
     */
    public static double toDouble(String value) {

        if (isEmpty(value)) return 0;

        double v = 0;

        try {
            v = Double.valueOf(value);

        } catch (Exception e) {

            LogUtils.e("转化异常:" + e);
        }


        return v;

    }


}
