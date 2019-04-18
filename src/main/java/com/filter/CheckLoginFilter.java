package com.filter;


import com.common.SystemConfig;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvjq20104 on 0017 2017/3/17.
 */
public class CheckLoginFilter implements Filter {
    private ApplicationContext context;
    private static final Logger logger = Logger.getLogger(CheckLoginFilter.class);

    public void init(FilterConfig config) throws ServletException {
        context = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
    }

    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) srequest;
        HttpServletResponse response = (HttpServletResponse) sresponse;
        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();
        uri = uri.substring(contextPath.length());
        boolean isLogin = false;
        Object o = request.getSession().getAttribute(SystemConfig.ManagerSessionName);
        if (o != null) {
           /* Sys_user user = (Sys_user) o;
            if (user != null) {
                isLogin = true;
            }*/
        }
        String cdurl = uri.substring(1);
        request.setAttribute(SystemConfig.req_uri, cdurl);
        //需要登录的页面
        if (NEED_LOGIN_URI.contains(uri)) {
            if (!isLogin) {
                response.sendRedirect(contextPath + "/login.htm");
                return;
            }
        }
       /* if (Cache.xtcdSet.contains(cdurl)) {
            HashSet<String> cdset = (HashSet<String>) request.getSession().getAttribute(SystemConfig.XtcdHasSetSessionName);
            if (cdset == null || !cdset.contains(cdurl)) {
                response.sendRedirect(contextPath + "/login.htm");
                return;
            }
        }*/
        chain.doFilter(srequest, sresponse);
    }

    public void destroy() {
        // TODO Auto-generated method stub
    }

    public static List<String> NEED_LOGIN_URI = new ArrayList<String>();

    static {
        //AchAction
        NEED_LOGIN_URI.add("/ach/list.htm");
        NEED_LOGIN_URI.add("/ach/mylist.htm");
        NEED_LOGIN_URI.add("/ach/report.htm");
        NEED_LOGIN_URI.add("/ach/close.htm");
        //CashAction
        NEED_LOGIN_URI.add("/cash/list.htm");
        NEED_LOGIN_URI.add("/cash/pay.htm");
        NEED_LOGIN_URI.add("/cash/paysave.htm");
        NEED_LOGIN_URI.add("/cash/detail.htm");
        //CityAction
        NEED_LOGIN_URI.add("/city/list.htm");
        NEED_LOGIN_URI.add("/city/modify.htm");
        NEED_LOGIN_URI.add("/city/save.htm");
        NEED_LOGIN_URI.add("/city/active.htm");
        NEED_LOGIN_URI.add("/city/propconf.htm");
        NEED_LOGIN_URI.add("/city/savepropconf.htm");
        //IndexAction
        NEED_LOGIN_URI.add("/index.htm");
        NEED_LOGIN_URI.add("/chartData.htm");
        //MemberInfoAction
        NEED_LOGIN_URI.add("/member/list.htm");
        NEED_LOGIN_URI.add("/member/account.htm");
        //WxMerchantAction
        NEED_LOGIN_URI.add("/merchant/list.htm");
        NEED_LOGIN_URI.add("/merchant/modify.htm");
        NEED_LOGIN_URI.add("/merchant/save.htm");
        NEED_LOGIN_URI.add("/merchant/active.htm");
        NEED_LOGIN_URI.add("/merchant/qrcode.htm");
        NEED_LOGIN_URI.add("/merchant/searchMerchant.htm");
        //OrderInfoAction
        NEED_LOGIN_URI.add("/order/list.htm");
        NEED_LOGIN_URI.add("/order/send.htm");
        NEED_LOGIN_URI.add("/order/dosend.htm");
        NEED_LOGIN_URI.add("/order/back.htm");
        NEED_LOGIN_URI.add("/order/doback.htm");
        NEED_LOGIN_URI.add("/order/info.htm");
        //RebateAction
        NEED_LOGIN_URI.add("/rebate/list.htm");
        NEED_LOGIN_URI.add("/rebate/account.htm");
        NEED_LOGIN_URI.add("/rebate/cash.htm");
        //TagAction
        NEED_LOGIN_URI.add("/tag/province.htm");
        NEED_LOGIN_URI.add("/tag/city.htm");
        NEED_LOGIN_URI.add("/tag/region.htm");
        //JsAction
        NEED_LOGIN_URI.add("/js/list.htm");
        NEED_LOGIN_URI.add("/js/modify.htm");
        NEED_LOGIN_URI.add("/js/save.htm");
        NEED_LOGIN_URI.add("/js/del.htm");
        NEED_LOGIN_URI.add("/js/qxtree.htm");
        NEED_LOGIN_URI.add("/js/qxtreesave.htm");
        NEED_LOGIN_URI.add("/js/yhjsfp.htm");
        NEED_LOGIN_URI.add("/js/jstreesave.htm");
        //UserAction
        NEED_LOGIN_URI.add("/user/list.htm");
        NEED_LOGIN_URI.add("/user/modify.htm");
        NEED_LOGIN_URI.add("/user/save.htm");
        NEED_LOGIN_URI.add("/user/checkloginname.htm");
        NEED_LOGIN_URI.add("/user/del.htm");
        NEED_LOGIN_URI.add("/user/resetpassword.htm");
        NEED_LOGIN_URI.add("/user/tochangepw.htm");
        NEED_LOGIN_URI.add("/user/changepassword.htm");
        NEED_LOGIN_URI.add("/user/merchants.htm");
        //ProductAction
        NEED_LOGIN_URI.add("/product/list.htm");
        NEED_LOGIN_URI.add("/product/modify.htm");
        NEED_LOGIN_URI.add("/product/active.htm");
        NEED_LOGIN_URI.add("/product/save.htm");
        NEED_LOGIN_URI.add("/product/detail.htm");
        NEED_LOGIN_URI.add("/product/toSpecial.htm");
        NEED_LOGIN_URI.add("/product/saveSpecial.htm");
        NEED_LOGIN_URI.add("/product/sortDra.htm");
        NEED_LOGIN_URI.add("/product/saveSort.htm");
        NEED_LOGIN_URI.add("/product/sortRecommend.htm");
    }
}
