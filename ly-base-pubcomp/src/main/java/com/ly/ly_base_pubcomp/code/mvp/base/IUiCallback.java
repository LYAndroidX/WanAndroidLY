package com.ly.ly_base_pubcomp.code.mvp.base;

import android.os.Bundle;

/**
 * UI回调接口
 */
public interface IUiCallback {

    void initBeforeView(Bundle savedInstanceState);

    //初始化视图
    void initData(Bundle savedInstanceState);

    //获取布局Id
    int getLayoutId();

}
