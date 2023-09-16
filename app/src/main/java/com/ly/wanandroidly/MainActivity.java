package com.ly.wanandroidly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ly.ly_base_routes.LYLoginRI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = (Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.i("壳工程", "点击了登录按钮");

//        ARouter.getInstance().build(LYLoginRI.LY_LoginPage_Path)
//                .withString("key1", "value1")
//                .withString("key2", "value2")
//                .navigation();
        LYLoginRI loginRS = (LYLoginRI)ARouter.getInstance().build(LYLoginRI.LY_LoginRS_Path).navigation();
        Log.d("壳工程", String.format("当前登录状态为：%s", String.valueOf(loginRS.isLogin())));

    }
}