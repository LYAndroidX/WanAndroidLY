package com.ly.ly_asset_login.code.service;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ly.ly_base_routes.LYLoginRI;

@Route(path = LYLoginRI.LY_LoginRS_Path)
public class LYLoginRS implements LYLoginRI {
    @Override
    public boolean isLogin() {
        Log.d("Login", "正在获取是否登录");
        return true;
    }

    @Override
    public void init(Context context) {

    }
}
