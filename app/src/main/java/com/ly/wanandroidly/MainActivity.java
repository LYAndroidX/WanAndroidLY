package com.ly.wanandroidly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ly.ly_base_imageloader.code.loader.ImageLoader;
import com.ly.ly_base_routes.LYLoginRI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = (Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);

        ImageView imageView = findViewById(R.id.imageView);
        ImageLoader.with(this)
                .url("https://bpic.51yuansu.com/pic3/cover/01/67/69/5958048963247_610.jpg")
//                .url("https://isparta.github.io/compare-webp/image/gif_webp/gif/1.gif")
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);

    }

    @Override
    public void onClick(View view) {
        Log.i("壳工程", "点击了登录按钮");

        ARouter.getInstance().build(LYLoginRI.LY_LoginPage_Path)
                .withString("key1", "value1")
                .withString("key2", "value2")
                .navigation();
//        LYLoginRI loginRS = (LYLoginRI)ARouter.getInstance().build(LYLoginRI.LY_LoginRS_Path).navigation();
//        Log.d("壳工程", String.format("当前登录状态为：%s", String.valueOf(loginRS.isLogin())));

    }
}