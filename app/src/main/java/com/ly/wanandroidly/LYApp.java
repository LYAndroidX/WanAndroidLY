package com.ly.wanandroidly;

import com.ly.ly_base_imageloader.code.loader.ImageLoader;
import com.ly.ly_base_network.code.NetworkApi;
import com.ly.ly_base_pubcomp.code.application.BaseApplication;

public class LYApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化网络框架
        NetworkApi.init(new NetworkRequiredInfo(this));
        //初始化图片加载框架
        ImageLoader.init(getApplicationContext());
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        ImageLoader.trimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        ImageLoader.clearAllMemoryCaches();
    }
}
