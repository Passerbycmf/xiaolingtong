package com.util;

import com.alibaba.fastjson.JSONObject;
import com.util.msg.JsonReqClient;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/10/17.
 */
public class MsgUtil {
    private static Logger logger = Logger.getLogger(MsgUtil.class);
    private static String ACCOUNT_SID="def092f998b7f8845931ad4b6c43e01a";
    private static String AUTH_TOKEN="988e46e492bc0b5ecc8fb56764a91e93";
    private static String APP_ID="0464b439243f47ef9955af81924d2b7d";

    /**
     *
     * @Title: sendCouponSMS
     * @Description: 发送验证码
     * @param phone   手机号："13800000000"
     * @param param    参数："汇宇市场,100,99b4fe6ec80ce230139447348bb380f2"
     */
    public static boolean sendMsg(String phone,String param){
        try {
            String templateId="114275";
            logger.info("templateId——————"+templateId);
            JsonReqClient client=new JsonReqClient();
            String result=client.templateSMS(ACCOUNT_SID, AUTH_TOKEN, APP_ID, templateId, phone, param);
            System.out.println("Response content is: " + result);

            JSONObject object = JSONObject.parseObject(result);
            String resp=object.getString("resp");
            JSONObject object2 = JSONObject.parseObject(resp);
            String respCode=object2.getString("respCode");
            System.out.println(respCode);
            if(!"000000".equals(respCode)){
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
