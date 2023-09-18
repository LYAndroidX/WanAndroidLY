package com.ly.ly_base_lifecycle.code;

import android.app.Application;
import android.content.res.AssetManager;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppLifeCycleManage implements LifecycleObserver {

    private static ArrayList<AppLifeCycleI> appList = new ArrayList();

    /**
     * 该方法必须在应用的application的onCreate方法执行
     * 该方法必须执行才可以监听应用的生命周期
     * 最好在init之前完成所有的registApp
     */
    public static void init(Application mainApp) {

        Log.d(Constant.COMP_TAG, "开始初始化生命周期管理器");

        String appConfigStr = parseFile("appConfig.json", mainApp);

        if (!appConfigStr.isEmpty()) {
            Gson gson = new Gson();
            List<AppConfig> appList = gson.fromJson(appConfigStr, new TypeToken<List<AppConfig>>() {}.getType());

            if (appList != null && !appList.isEmpty()) {
                for (AppConfig appConfig: appList) {
                    Log.d(Constant.COMP_TAG, String.format("开始注册组件：%s", appConfig));

                    if (appConfig.applicationClassName != null && !appConfig.applicationClassName.isEmpty()) {
                        try {
                            Class<?> cls = Class.forName(appConfig.applicationClassName);
                            Constructor<?> constructor = cls.getConstructor(Application.class);
                            AppLifeCycleI compApp = (AppLifeCycleI)constructor.newInstance(mainApp);
                            registApp(compApp);
                            Log.d(Constant.COMP_TAG, String.format("组件注册成功：%s", appConfig.id));
                        }
                        catch (Exception e) {
                            Log.d(Constant.COMP_TAG, String.format("组件注册失败：%s，请检查注册时所填写的applicationClassName值是否正确，需要是全类名，当前填写的为：%s", appConfig.id, appConfig.applicationClassName));
                            e.printStackTrace();
                        }

                    }

                }
            }
        }

        ProcessLifecycleOwner.get().getLifecycle().addObserver(new AppLifeCycleManage());
    }

    /**
     * App创建时执行一次
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate(){
        if (appList.isEmpty()) {
            return;
        }
        Collections.sort(appList, new ApplicationLifecycleComparator());
        for (AppLifeCycleI app : appList) {
            app.onCreate();
        }
    }

    /**
     * App回到前台时被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onStart(){
        if (appList.isEmpty()) {
            return;
        }
        Collections.sort(appList, new ApplicationLifecycleComparator());
        for (AppLifeCycleI app : appList) {
            app.onStart();
        }
    }

    /**
     * App回到前台时被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume(){
        if (appList.isEmpty()) {
            return;
        }
        Collections.sort(appList, new ApplicationLifecycleComparator());
        for (AppLifeCycleI app : appList) {
            app.onResume();
        }
    }

    /**
     * App退到后台时调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onPause(){
        if (appList.isEmpty()) {
            return;
        }
        Collections.sort(appList, new ApplicationLifecycleComparator());
        for (AppLifeCycleI app : appList) {
            app.onPause();
        }
    }

    /**
     *  App退到后台时调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop(){
        if (appList.isEmpty()) {
            return;
        }
        Collections.sort(appList, new ApplicationLifecycleComparator());
        for (AppLifeCycleI app : appList) {
            app.onStop();
        }
    }

    /**
     * 系统不会分发ON_DESTROY事件，永远不会被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy(){
        if (appList.isEmpty()) {
            return;
        }
        Collections.sort(appList, new ApplicationLifecycleComparator());
        for (AppLifeCycleI app : appList) {
            app.onDestroy();
        }
    }

    public static <T extends AppLifeCycleI> void registApp(T app) {
        if (app == null) {
            return;
        }
        if (!appList.contains(app)) {
            appList.add(app);
        }
    }

    public static <T extends AppLifeCycleI> void unRegistApp(T app) {
        if (app == null) {
            return;
        }
        if (appList.contains(app)) {
            appList.remove(app);
        }
    }

    /**
     * 优先级比较器，优先级大的排在前面
     */
    private static class ApplicationLifecycleComparator implements Comparator<AppLifeCycleI> {

        @Override
        public int compare(AppLifeCycleI o1, AppLifeCycleI o2) {
            int p1 = o1.getPriority();
            int p2 = o2.getPriority();
            return p2 - p1;
        }
    }

    private static String parseFile(String fileName, Application app) {

        AssetManager assets = app.getAssets();
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder builder = new StringBuilder();
        try {
            is = assets.open(fileName);
            br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {

            }
        }

        return builder.toString();
    }
}
