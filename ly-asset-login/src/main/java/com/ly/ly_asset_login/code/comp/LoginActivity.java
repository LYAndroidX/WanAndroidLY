package com.ly.ly_asset_login.code.comp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ly.ly_asset_login.R;
import com.ly.ly_asset_login.code.constant.Constant;
import com.ly.ly_base_routes.LYLoginRI;

@Route(path = LYLoginRI.LY_LoginPage_Path)
public class LoginActivity extends AppCompatActivity {

    @Autowired
    public String key1;

    @Autowired
    public String key2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ARouter.getInstance().inject(this);

        Log.d(Constant.COMP_TAG, String.format("参数1：%s\n参数2：%s", key1, key2));
    }
}