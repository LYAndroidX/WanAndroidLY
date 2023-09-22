package com.ly.ly_base_network.code.interceptor;

import android.util.Log;

import com.ly.ly_base_network.code.constant.Constant;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * 返回拦截器(响应拦截器)
 *
 * @author llw
 */
public class ResponseInterceptor implements Interceptor {

    /**
     * 拦截
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        long requestTime = System.currentTimeMillis();
        Response response = chain.proceed(chain.request());
        Log.d(Constant.COMP_TAG, "请求耗时=" + (System.currentTimeMillis() - requestTime) + "ms");
        return response;
    }
}
