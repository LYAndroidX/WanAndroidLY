package com.ly.ly_asset_login.code.api;

import com.ly.ly_asset_common.code.WanResponse;
import com.ly.ly_asset_login.code.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 登录API服务接口
 */
public interface LoginApiService {

    /**
     * 登录
     * 方法： POST
     * 参数：
     * username，password
     * 登录后会在cookie中返回账号密码，只要在客户端做cookie持久化存储即可自动登录验证。
     */
    @FormUrlEncoded
    @POST("/user/login")
    Observable<WanResponse<LoginBean>> login(@Field("username") String username,
                                  @Field("password") String password);
}
