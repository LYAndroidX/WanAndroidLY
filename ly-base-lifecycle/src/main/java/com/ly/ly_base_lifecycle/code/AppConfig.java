package com.ly.ly_base_lifecycle.code;

/**
* 组件化的组件配置文件信息
 */
public class AppConfig {
    /**
    * 组件名称
     */
    public String name;
    /**
     * 组件唯一标识
     */
    public String id;
    /**
     * 组件描述
     */
    public String desc;
    /**
     * 组件application类名
     */
    public String applicationClassName;

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", applicationClassName='" + applicationClassName + '\'';
    }
}