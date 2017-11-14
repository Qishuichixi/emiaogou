package com.emiaogou.fragment;

import com.emiaogou.tools.LogUtils;

/**
 * QQ:798150439
 * TEL:18770813363
 * Email:qishuichixi@163.com
 * Created by zhou on 2017/11/13
 * PACKAGE_NAME:com.emiaogou.fragment
 * PROJECT_NAME:emiaogou
 * Desc:
 */

public class FragmentFactory {

    /**
     * 主页fragment
     */
    public static BaseFragment createFragment(int position) {

        BaseFragment fragment = null;

        if (position == 0) {
            fragment = new HomeFragment();
        } else if (position == 1) {
            fragment = new ClassifyFragment();
        } else if (position == 2) {
            fragment = new ShoppingFragment();
        } else if (position == 3) {
            fragment = new MineFragment();
        }

        LogUtils.e("首页新建了第" + position + "个fragment...");

        return fragment;

    }


}
