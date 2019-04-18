package com.util;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by lvjianqing on 2017/8/3.
 */
public class ModelAndJson {
    private JSONObject json;

    public ModelAndJson() {
        json = new JSONObject();
        setTrue("操作成功");
    }

    /**
     * @param errMessage 参数可以为null
     */
    public void setTrue(String errMessage) {
        json.put("errMessage", StringUtil.blanknull(errMessage));
        json.put("errCode", "0");
        json.put("isSuccess", true);
}

    /**
     * @param errCode
     * @param errMessage 参数可以为null
     */
    public void setFalse(String errCode, String errMessage) {
        json.put("errMessage", StringUtil.blanknull(errMessage));
        json.put("errCode", StringUtil.isEmpty(errCode) ? "-1" : errCode);
        json.put("isSuccess", false);
    }

    public void put(String key, Object value) {
        if (StringUtil.isEmpty(key) || value == null) {
            return;
        }
        json.put(key, value);
    }

    public String toString() {
        return json.toString();
    }

    public JSONObject getJson(){
        return json;
    }
}
