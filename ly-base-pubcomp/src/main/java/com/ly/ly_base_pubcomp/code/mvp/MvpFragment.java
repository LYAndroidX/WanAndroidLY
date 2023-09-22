package com.ly.ly_base_pubcomp.code.mvp;

import android.os.Bundle;

import com.ly.ly_base_pubcomp.code.mvp.base.BaseFragment;
import com.ly.ly_base_pubcomp.code.mvp.base.BasePresenter;
import com.ly.ly_base_pubcomp.code.mvp.base.BaseView;

/**
 * 适用于需要访问网络接口的Fragment
 *
 */
public abstract class MvpFragment<P extends BasePresenter> extends BaseFragment {

    protected P mPresenter;

    /**
     * 创建Presenter
     */
    protected abstract P createPresent();

    @Override
    public void initBeforeView(Bundle savedInstanceState) {
        mPresenter = createPresent();
        mPresenter.attachView((BaseView) this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
