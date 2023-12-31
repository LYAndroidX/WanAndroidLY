package com.ly.wanandroidly;

import android.app.Application;

import com.ly.ly_base_network.code.INetworkRequiredInfo;

public class NetworkRequiredInfo implements INetworkRequiredInfo {
    private final Application application;

    public NetworkRequiredInfo(Application application){
        this.application = application;
    }

    /**
     * 版本名
     */
    @Override
    public String getAppVersionName() {
        return com.ly.wanandroidly.BuildConfig.VERSION_NAME;
    }
    /**
     * 版本号
     */
    @Override
    public String getAppVersionCode() {
        return String.valueOf(com.ly.wanandroidly.BuildConfig.VERSION_CODE);
    }

    /**
     * 是否为debug
     */
    @Override
    public boolean isDebug() {
        return com.ly.wanandroidly.BuildConfig.DEBUG;
    }

    /**
     * 应用全局上下文
     */
    @Override
    public Application getApplicationContext() {
        return application;
    }
}
