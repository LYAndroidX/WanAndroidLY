package com.ly.ly_asset_login.code.app;

import android.app.Application;
import android.util.Log;

import com.ly.ly_asset_login.code.constant.Constant;
import com.ly.ly_base_lifecycle.code.AppLifeCycle;
import com.ly.ly_base_lifecycle.code.AppLifeCycleI;

@AppLifeCycle
public class LoginApplication extends AppLifeCycleI {
    public LoginApplication(Application application) {
        super(application);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constant.COMP_TAG, "执行了onCreate方法");
    }
}
