package com.emiaogou.holder;

import android.content.Context;
import android.view.View;

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

public abstract class BaseHolder<Data> {

    private View contentView;
    private Data data;
    protected Context context = UiUtils.getContext();

    public BaseHolder() {
        contentView = initView();
        contentView.setTag(this);
    }

    /**
     * 创建界面
     */
    public abstract View initView();

    public View getContentView() {
        return contentView;
    }

    public void setData(Data data) {
        this.data = data;
        refreshView(data);
    }

    /**
     * 根据数据刷新界面
     */
    public abstract void refreshView(Data data);




}
