package com.ly.ly_asset_login.code.comp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ly.ly_asset_login.R;
import com.ly.ly_asset_login.code.constant.Constant;
import com.ly.ly_asset_login.code.contract.LoginContract;
import com.ly.ly_base_pubcomp.code.mvp.MvpActivity;
import com.ly.ly_base_routes.LYLoginRI;

@Route(path = LYLoginRI.LY_LoginPage_Path)
public class LoginActivity extends MvpActivity<LoginContract.LoginPresenter> implements LoginContract.ILoginView, View.OnClickListener {

    @Autowired
    public String key1;

    @Autowired
    public String key2;

    @Override
    public void loginSuccess() {
        Log.d(Constant.COMP_TAG, "登录成功传到登录页面了。。。");
    }

    @Override
    public void loginFailed() {
        Log.d(Constant.COMP_TAG, "登录失败传到登录页面了。。。");
    }

    @Override
    protected LoginContract.LoginPresenter createPresenter() {
        return new LoginContract.LoginPresenter();
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        ARouter.getInstance().inject(this);

        Log.d(Constant.COMP_TAG, String.format("参数1：%s\n参数2：%s", key1, key2));

        Button loginBtn = (Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View view) {
        mPresenter.login("suxiaoyao", "yaoyao920927");
    }
}