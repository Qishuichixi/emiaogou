package com.emiaogou.activity;


import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.emiaogou.R;
import com.emiaogou.adapter.HomeFragmentTabAdapter;
import com.emiaogou.fragment.FragmentFactory;
import com.emiaogou.tools.CommonUtils;
import com.emiaogou.tools.ToastUtils;
import com.emiaogou.tools.UiUtils;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements HomeFragmentTabAdapter.CheckedChangedListener {

    private RadioGroup rgs;
    private List<Fragment> fragments;
    private HomeFragmentTabAdapter adapter;
    public RadioGroup radioGroup;
    public int checkedId;
    public int index;

    @Override
    protected int initViews() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEvent() {

        CommonUtils.setTheme(this);

        rgs=CommonUtils.f(this,R.id.main_rg);

        fragments = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            fragments.add(FragmentFactory.createFragment(i));
        }
        adapter = new HomeFragmentTabAdapter(this, fragments, R.id.main_frag, rgs);
        adapter.setOnRgsExtraCheckedChangedListener(this);


    }

    @Override
    public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index) {

        this.radioGroup = radioGroup;
        this.checkedId = checkedId;
        this.index = index;
    }

    /**
     * 点击返回键退出程序
     */
    private static Boolean isExit = false;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {


            if (isExit == false) {
                isExit = true;

                ToastUtils.show("再按一次退出应用");

                UiUtils.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 2000);

            } else {
                //退出程序
                BaseActivity.killAll();
            }
        }
        return false;
    }

}
