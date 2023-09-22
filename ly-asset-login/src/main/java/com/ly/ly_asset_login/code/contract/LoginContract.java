package com.ly.ly_asset_login.code.contract;

import android.annotation.SuppressLint;
import android.util.Log;

import com.ly.ly_asset_common.code.WanResponse;
import com.ly.ly_asset_login.code.api.LoginApiService;
import com.ly.ly_asset_login.code.bean.LoginBean;
import com.ly.ly_base_network.code.NetworkApi;
import com.ly.ly_base_network.code.constant.Constant;
import com.ly.ly_base_network.code.observer.BaseObserver;
import com.ly.ly_base_pubcomp.code.mvp.base.BasePresenter;
import com.ly.ly_base_pubcomp.code.mvp.base.BaseView;

/**
 * 登录订阅器
 */
public class LoginContract {

    public static class LoginPresenter extends BasePresenter<ILoginView> {

        @SuppressLint("CheckResult")
        public void login(String userName, String password) {

            LoginApiService loginApiService = NetworkApi.createService(LoginApiService.class);
            loginApiService.login(userName, password)
                            .compose(NetworkApi.applySchedulers(new BaseObserver<WanResponse<LoginBean>>() {
                                @Override
                                public void onSuccess(WanResponse<LoginBean> loginBeanWanResponse) {
                                    Log.d(Constant.COMP_TAG, loginBeanWanResponse.toString());
                                    if (getView() != null) {
                                        getView().loginSuccess();
                                    }
                                }

                                @Override
                                public void onFailure(Throwable e) {
                                    if (getView() != null) {
                                        getView().loginFailed();
                                    }
                                }
                            }));
        }
    }
    public interface ILoginView extends BaseView {

        void loginSuccess();

        void loginFailed();
    }
}
