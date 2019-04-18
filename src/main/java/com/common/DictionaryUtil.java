package com.common;

import com.util.StringUtil;

import java.util.Collection;
import java.util.Set;

/**
 * Created by admin on 2018/2/7.
 */
public class DictionaryUtil {
    private static DictionaryUtil dict = null;

    private DictionaryUtil() {
    }

    public static synchronized DictionaryUtil init() {
        if (dict == null) {
            dict = new DictionaryUtil();
        }
        return dict;
    }

    /**
     * 根据dic_type生产select下拉列表
     *
     * @param dic_type
     * @param default_value
     * @return
     */
    public String getOptions(String dic_type, String default_value) {
        if (StringUtil.isEmpty(dic_type) || Cache.dictMap == null || !Cache.dictMap.containsKey(dic_type)) {
            return "<option></option>";
        }
        Collection<String[]> vals = Cache.dictMap.get(dic_type);
        StringBuffer sb = new StringBuffer();
        for (String[] strs : vals) {
            String dic_value = strs[0];
            String dic_name = strs[1];
            if (!StringUtil.isEmpty(default_value) && dic_value.equals(default_value)) {
                sb.append("<option selected value=\"").append(dic_value).append("\">").append(dic_name).append("</option>");
            } else {
                sb.append("<option value=\"").append(dic_value).append("\">").append(dic_name).append("</option>");
            }
        }
        return sb.toString();
    }

    /**
     * 根据dic_val获取dic_name
     *
     * @param dic_type
     * @param dic_value
     * @return
     */
    public String getDicName(String dic_type, String dic_value) {
        if (StringUtil.isEmpty(dic_type) || Cache.dictMap == null || !Cache.dictMap.containsKey(dic_type)) {
            return "";
        }
        Collection<String[]> vals = Cache.dictMap.get(dic_type);
        for (String[] strs : vals) {
            if (strs[0].equals(dic_value)) {
                return strs[1];
            }
        }
        return "";
    }

    /**
     * 根据dic_name获取dic_value
     *
     * @param dic_type
     * @param dic_name
     * @return
     */
    public String getDicValue(String dic_type, String dic_name) {
        if (StringUtil.isEmpty(dic_type) || Cache.dictMap == null || !Cache.dictMap.containsKey(dic_type)) {
            return "";
        }
        Collection<String[]> vals = Cache.dictMap.get(dic_type);
        for (String[] strs : vals) {
            if (strs[1].equals(dic_name)) {
                return strs[0];
            }
        }
        return "";
    }

    /**
     * 获取城市名称
     *
     * @param cityId
     * @return
     */
    public String getCityName(String cityId) {
        if (cityId == null || Cache.cityMap == null || !Cache.cityMap.containsKey(cityId)) {
            return "";
        }
        String cityName = Cache.cityMap.get(cityId);
        return cityName;
    }

    /**
     * 获取城市下拉列表
     *
     * @param default_value
     * @return
     */
    public String getCityOptions(String default_value) {
        if (Cache.cityMap == null) {
            return "<option value=''>暂无城市</option>";
        }
        Set<String> keys = Cache.cityMap.keySet();
        StringBuffer sb = new StringBuffer();
        sb.append("<option value=''>请选择</option>");
        for (String id : keys) {
            if (default_value != null && id.equals(default_value)) {
                sb.append("<option selected value=\"").append(id).append("\">").append(Cache.cityMap.get(id)).append("</option>");
            } else {
                sb.append("<option value=\"").append(id).append("\">").append(Cache.cityMap.get(id)).append("</option>");
            }
        }
        return sb.toString();
    }

    /**
     * 获取角色下拉列表
     *
     * @param default_value
     * @return
     */
    public String getjsOptions(String default_value) {
        if (Cache.jsMap == null) {
            return "<option value=''>暂无角色</option>";
        }
        Set<String> keys = Cache.jsMap.keySet();
        StringBuffer sb = new StringBuffer();
        sb.append("<option value=''>请选择</option>");
        for (String id : keys) {
            if (default_value != null && id.equals(default_value)) {
                sb.append("<option selected value=\"").append(id).append("\">").append(Cache.jsMap.get(id)).append("</option>");
            } else {
                sb.append("<option value=\"").append(id).append("\">").append(Cache.jsMap.get(id)).append("</option>");
            }
        }
        return sb.toString();
    }
}
