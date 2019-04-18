package com.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Administrator on 2017/9/29.
 */
public abstract class BaseInterceptor extends HandlerInterceptorAdapter {
    public String success;
    public String failed;

    /**
     * 校验是否是登录状态检测的注解
     * @param handler
     * @return
     */
    public abstract   boolean isWxLoginHandler(Object handler);

    /**
     * 校验是否是会员激活状态检测的注解
     * @param handler
     * @return
     */
    public abstract   boolean isMemberActivityHandler(Object handler);

    /**
     * 微信用户登录状态检测逻辑
     *
     * @param response
     * @return
     * @throws Exception
     */
    public abstract boolean checkWxLogin(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * 用户会员资格检测逻辑
     *
     * @param response
     * @return
     * @throws Exception
     */
    public abstract boolean checkMemberActivity(HttpServletRequest request, HttpServletResponse response) throws Exception;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        handler.getClass().isAssignableFrom(HandlerMethod.class);
        if (isWxLoginHandler(handler)) {//判断微信登录状态的注解是否存在
            return checkWxLogin(request,response);/*校验微信用户登录状态*/
        }
        return super.preHandle(request, response, handler);
    }

    //public abstract boolean runHandler(HttpServletRequest request, HttpServletResponse response);
}
