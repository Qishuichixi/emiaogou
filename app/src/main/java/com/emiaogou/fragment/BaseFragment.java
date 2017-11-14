package com.emiaogou.fragment;

import android.support.v4.app.Fragment;

/**
 * QQ:798150439
 * TEL:18770813363
 * Email:qishuichixi@163.com
 * Created by zhou on 2017/11/13
 * PACKAGE_NAME:com.emiaogou.fragment
 * PROJECT_NAME:emiaogou
 * Desc:
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {

    private View view;
    public abstract int getLayoutId();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        if (null != view) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (null != parent) {
                parent.removeView(view);
            }
        } else {
            view = inflater.inflate(getLayoutId(), container, false);
            initEvents(view);//// 控件初始化
        }

        return view;
    }

    protected abstract void initEvents(View view) ;

}

