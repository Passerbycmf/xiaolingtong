package com.common;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by lvjianqing on 2017/7/27.
 */
public class BaseController {

    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public HttpSession getSession() {
        HttpSession session = this.getRequest().getSession();
        return session;
    }

    /*protected Sys_user getSysUser() {
        HttpServletRequest request = getRequest();
        Object o = request.getSession().getAttribute(SystemConfig.ManagerSessionName);
        if (o == null) {
            return null;
        } else {
            Sys_user user = (Sys_user) o;
            return user;
        }
    }*/

    protected Long getJsid() {
        HttpServletRequest request = getRequest();
        Object o = request.getSession().getAttribute(SystemConfig.JsSessionName);
        if (o == null) {
            return null;
        } else {
            Long jsid = (Long) o;
            return jsid;
        }
    }

    /**
     * 根据角色id过滤查询列表
     *
     * @param
     */
   /* protected boolean filterParaMap(HashMap<String, Object> paraMap) {
        HttpServletRequest request = getRequest();
        Long jsid = getJsid();
        if (jsid != null) {
            paraMap.put("jslv", jsid);
            if (jsid != 2) {
                paraMap.put("cityid", getSysUser().getCityid());
                return false;
            } else {//超级管理员
                if (request.getParameter("cityid") != null) paraMap.put("cityid", request.getParameter("cityid"));
            }
        }
        return true;
    }*/

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
