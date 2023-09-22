package com.ly.ly_base_pubcomp.code.mvp;

import android.os.Bundle;

import com.ly.ly_base_pubcomp.code.mvp.base.BaseActivity;
import com.ly.ly_base_pubcomp.code.mvp.base.BasePresenter;
import com.ly.ly_base_pubcomp.code.mvp.base.BaseView;

/**
 * 适用于需要访问网络接口的Activity
 *
 */
public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {

    protected P mPresenter;

    /**
     * 创建Presenter
     */
    protected abstract P createPresenter();

    @Override
    public void initBeforeView(Bundle savedInstanceState) {
        //创建
        mPresenter = createPresenter();
        //绑定View
        mPresenter.attachView((BaseView) this);
    }

    /**
     * 页面销毁时解除绑定
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
