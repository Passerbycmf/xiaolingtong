package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.bean.User;
import com.common.BaseController;
import com.common.Result;
import com.common.SystemConfig;
import com.service.UserService;
import com.util.Config;
import com.util.HttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/6/1 11:09
 * @version: 1.0
 **/
@Controller
@RequestMapping("user")
public class WxUserController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /**
     * 登陆接口
     * 前端code 发送到该处，使用code 换取openid 和 session_key
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public Result login(String code) {
        JSONObject ret = new JSONObject();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        url = url.replace("APPID", Config.getString("wx.appid"));
        url = url.replace("SECRET", Config.getString("wx.appsecret"));
        url = url.replace("JSCODE", code);
        logger.info("getOpenId replace之后的url:" + url);
        String result = HttpClient.get(url);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String openId = (String) jsonObject.get("openid");
        String sessionKey = (String) jsonObject.get("session_key");
        if (StringUtils.isBlank(openId) || StringUtils.isBlank(sessionKey)) {
            ret.put("status", "error");
        } else {
            ret.put("status", "ok");
        }
        ret.put("openId", openId);
        ret.put("sessionKey", sessionKey);
        //是否存在用户
        User user=userService.selectUserByOpenid(openId);
        if (user==null){
            User user1=new User();
            user1.setOpenid(openId);
            userService.insert(user1);
            ret.put("userId",user1.getId());
        }else {
            ret.put("userId",user.getId());
        }
        HttpSession session=getRequest().getSession();
        String sessionId=getRequest().getSession().getId();
        session.setAttribute(SystemConfig.sessionId,sessionKey);
        ret.put("sessionId",sessionId);
        return Result.createBySuccess(ret);
    }


    /**
     * 获取用户信息
     * @param openId
     * @param access_token
     * @return
     */
    @RequestMapping("/userInfo")
    @ResponseBody
    public JSONObject getWxUserByOpenId(String openId, String access_token) {
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        logger.info("WxConfigServiceImpl/getObjByOpenId url:" + url);
        url = url.replace("ACCESS_TOKEN", access_token);
        url = url.replace("OPENID", openId);
        logger.info("replace之后的url:" + url);
        String result = HttpClient.get(url);
        if (org.apache.commons.lang.StringUtils.isNotBlank(result)) {
            logger.info("result：" + result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            return jsonObject;
        }
        return null;
    }
}
