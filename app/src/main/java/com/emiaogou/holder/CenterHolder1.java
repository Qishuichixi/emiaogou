package com.emiaogou.holder;

import android.view.View;

import com.emiaogou.R;
import com.emiaogou.tools.UiUtils;

/**
 * QQ:798150439
 * TEL:18770813363
 * Email:qishuichixi@163.com
 * Created by zhou on 2017/11/13
 * PACKAGE_NAME:com.emiaogou.holder
 * PROJECT_NAME:emiaogou
 * Desc:
 */

public class CenterHolder1 extends BaseHolder {
    @Override
    public View initView() {

        View v = UiUtils.inflate(R.layout.holder_center1);

        return v;
    }

    @Override
    public void refreshView(Object o) {

    }
}
