package com.ly.ly_base_pubcomp.code.mvp.base;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ly.ly_base_pubcomp.R;
import com.ly.ly_base_pubcomp.code.application.BaseApplication;

import java.util.Objects;

/**
 * 基类Activity，普通Activity继承即可。
 */
public abstract class BaseActivity extends AppCompatActivity implements IUiCallback {

    //Activity 上下文
    protected Activity context;
    //弹窗
    private Dialog mDialog;

    private static final int FAST_CLICK_DELAY_TIME = 500;
    private static long lastClickTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定视图
        initBeforeView(savedInstanceState);
        //获取Activity的上下文
        this.context = this;
        BaseApplication.getActivityManager().addActivity(this);
        //绑定视图XML
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }

        initData(savedInstanceState);
    }


    /**
     * Toast消息提示  字符
     * @param llw
     */
    protected void showMsg(CharSequence llw) {
        Toast.makeText(context, llw, Toast.LENGTH_SHORT).show();
    }

    /**
     * Toast消息提示  资源ID
     * @param resourceId
     */
    protected void showMsg(int resourceId){
        Toast.makeText(context, resourceId, Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹窗出现
     */
    protected void showLoadingDialog() {
        if (mDialog == null) {
            mDialog = new Dialog(context, R.style.loading_dialog);
        }
        mDialog.setContentView(R.layout.dialog_loading);
        mDialog.setCancelable(false);
        Objects.requireNonNull(mDialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        mDialog.show();
    }

    /**
     * 弹窗隐藏
     */
    protected void hideLoadingDialog() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
        mDialog = null;
    }

    /**
     * 返回 不需要参数
     */
    protected void Back(){
        context.finish();
        if(!isFastClick()){
            context.finish();
        }
    }

    /**
     * 返回 toolbar控件点击
     *
     * @param toolbar
     */
    protected void Back(Toolbar toolbar) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.finish();
                if (!isFastClick()) {
                    context.finish();
                }
            }
        });
    }



    /**
     * 两次点击间隔不能少于500ms
     *
     * @return flag
     */
    protected static boolean isFastClick() {
        boolean flag = true;
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) >= FAST_CLICK_DELAY_TIME) {
            flag = false;
        }
        lastClickTime = currentClickTime;

        return flag;
    }


}
