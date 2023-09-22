package com.ly.ly_base_pubcomp.code.application;

import android.annotation.SuppressLint;
import android.content.Context;

import com.ly.ly_base_pubcomp.code.utils.ActivityManager;

/**
 * 工程管理
 */
public class BaseApplication extends CompBaseApplication {

    private static ActivityManager activityManager;
    @SuppressLint("StaticFieldLeak")
    private  static BaseApplication application;
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        //声明Activity管理
        activityManager=new ActivityManager();
        context = getApplicationContext();
        application=this;

    }

    public static ActivityManager getActivityManager() {
        return activityManager;
    }

    //内容提供器
    public static Context getContext(){
        return context;
    }

    public static BaseApplication getApplication() {
        return application;
    }
}

