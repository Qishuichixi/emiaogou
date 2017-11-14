package com.emiaogou.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import java.util.List;

/**
 * QQ:798150439
 * TEL:18770813363
 * Email:qishuichixi@163.com
 * Created by zhou on 2017/11/13
 * PACKAGE_NAME:com.emiaogou.adapter
 * PROJECT_NAME:emiaogou
 * Desc:
 */

public class HomeFragmentTabAdapter implements RadioGroup.OnCheckedChangeListener {

    private List<Fragment> fragments;
    private RadioGroup rgs;
    private FragmentActivity fragmentActivity;
    private int fragmentContentId;

    private int currentTab;

    private CheckedChangedListener onRgsExtraCheckedChangedListener;

    public HomeFragmentTabAdapter(FragmentActivity fragmentActivity, List<Fragment> fragments, int fragmentContentId, RadioGroup rgs) {
        this.fragments = fragments;
        this.rgs = rgs;
        this.fragmentActivity = fragmentActivity;
        this.fragmentContentId = fragmentContentId;
        FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
        ft.add(fragmentContentId, fragments.get(0));
        ft.commit();
        rgs.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

        for (int i = 0; i < rgs.getChildCount(); i++) {
            if (rgs.getChildAt(i).getId() == checkedId) {
                if (null != onRgsExtraCheckedChangedListener) {
                    onRgsExtraCheckedChangedListener.OnRgsExtraCheckedChanged(radioGroup, checkedId, i);
                }

                setFragment(i, false);
            }
        }
    }

    public void setFragment(int i, boolean flag) {
        Fragment fragment = fragments.get(i);
        FragmentTransaction ft = obtainFragmentTransaction(i);
        getCurrentFragment().onPause();
        if (fragment.isAdded()) {
            fragment.onResume();
        } else {
            ft.add(fragmentContentId, fragment);
        }
        if (flag) {
            showTabCAS(i);
            ft.commitAllowingStateLoss();
        } else {
            showTab(i);
            ft.commit();
        }
    }

    private void showTab(int idx) {
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            FragmentTransaction ft = obtainFragmentTransaction(idx);
            if (idx == i) {
                ft.show(fragment);
            } else {
                ft.hide(fragment);
            }
            ft.commit();
        }
        currentTab = idx;
    }

    private void showTabCAS(int idx) {
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            FragmentTransaction ft = obtainFragmentTransaction(idx);
            if (idx == i) {
                ft.show(fragment);
            } else {
                ft.hide(fragment);
            }
            ft.commitAllowingStateLoss();
        }
        currentTab = idx;
    }


    private FragmentTransaction obtainFragmentTransaction(int index) {
        FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
        return ft;
    }

    public int getCurrentTab() {
        return currentTab;
    }

    public Fragment getCurrentFragment() {
        return fragments.get(currentTab);
    }


    public void setOnRgsExtraCheckedChangedListener(CheckedChangedListener onRgsExtraCheckedChangedListener) {
        this.onRgsExtraCheckedChangedListener = onRgsExtraCheckedChangedListener;
    }

    public interface CheckedChangedListener {

        void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index);
    }

}

