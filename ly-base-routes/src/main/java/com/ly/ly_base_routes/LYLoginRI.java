package com.ly.ly_base_routes;

import com.ly.ly_base_router.LYRouterInterface;

public interface LYLoginRI extends LYRouterInterface {

    /*
    * 登录对外提供的服务地址
    */
    String LY_LoginRS_Path = "/login/LYLoginRS";

    /*
    * 登录页面
    */
    String LY_LoginPage_Path = "/login/index";
    /*
    * 判断是否登录
    * @return 返回是否登录
    */
    boolean isLogin();

}
