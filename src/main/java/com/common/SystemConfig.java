package com.common;

/**
 * Created by lvjianqing on 2017/8/1.
 */
public class SystemConfig {
    public static String JsSessionName = "manager_js";//在session中存放登录用户角色
    /*WX*/
    public static String UserSession = "cur_user";//在session中存放登录用户信息的key
    public static String UserIdSession = "cur_user_id";//在session中存放登录用户信息的key
    public static String openidSession = "cur_openid";//在session中存放登录用户openid的key
    public static String sessionId="sessionId"; //在session中存放登录用户sessionKey的key
    public static String CityIdSession = "cur_city_id";//在session中存放当前城市编号信息的key
    public static String CityNameSession = "cur_city_name";//在session中存放当前城市名称信息的key
    public static String CitySession = "cur_city";//在session中存放当前城市信息的key
    public static String draProListSession = "dra_pro_list";//在session中存放所选引流商品集合的key
    public static String orderAmountSession = "order_amount";//在session中存放订单金额的key
    public static String orderAddressSession = "order_address";//在session中存放订单地址的key
    public static String MemberSession="memberSession";
    public static String ManagerSessionName="managerSessionName";
    public static String req_uri="req_uri";
}
