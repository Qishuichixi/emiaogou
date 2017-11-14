package com.emiaogou.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.emiaogou.R;
import com.emiaogou.holder.CenterHolder1;
import com.emiaogou.holder.CenterHolder2;
import com.emiaogou.holder.CenterHolder3;
import com.emiaogou.holder.CenterHolder4;
import com.emiaogou.tools.CommonUtils;
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

public class MineFragment extends BaseFragment {

    private LinearLayout center_ll;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initEvents(View view) {

        LogUtils.e("MineFragment");

        center_ll = CommonUtils.f(view, R.id.center_ll);

        CenterHolder1 CenterHolder1 = new CenterHolder1();
        View v1 = CenterHolder1.getContentView();

        CenterHolder2 CenterHolder2 = new CenterHolder2();
        View v2 = CenterHolder2.getContentView();

        CenterHolder3 CenterHolder3 = new CenterHolder3();
        View v3 = CenterHolder3.getContentView();

        CenterHolder4 CenterHolder4 = new CenterHolder4();
        View v4 = CenterHolder4.getContentView();

        center_ll.addView(v1);
        center_ll.addView(v2);
        center_ll.addView(v3);
        center_ll.addView(v4);
    }
}
