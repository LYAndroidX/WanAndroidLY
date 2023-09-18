package com.ly.ly_base_lifecycle.code;

import android.app.Application;

import androidx.annotation.IntRange;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

public abstract class AppLifeCycleI {

    private Application app;

    //优先级 越大，优先级越高
    int Max_Priority = 10;
    int Min_Priority = 0;
    int Normal_Priority = 5;

    public AppLifeCycleI(Application application) {
        this.app = application;
    }

    public Application getApp() {
        return app;
    }

    /**
     * 获取优先级，priority 越大，优先级越高
     * 默认5 最小0 最大10
     */
    public int getPriority() {
        return Normal_Priority;
    }

    /**
     * App创建时执行一次
     */
    public void onCreate(){
    }

    /**
     * App回到前台时被调用
     */
    public void onStart(){
    }

    /**
     * App回到前台时被调用
     */
    public void onResume(){
    }

    /**
     * App退到后台时调用
     */
    public void onPause(){
    }

    /**
     *  App退到后台时调用
     */
    public void onStop(){
    }

    /**
     * 系统不会分发ON_DESTROY事件，永远不会被调用
     */
    public void onDestroy(){
    }

}
