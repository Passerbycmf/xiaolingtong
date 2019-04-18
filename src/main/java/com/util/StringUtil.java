package com.util;

import com.google.common.base.Strings;

/**
 * Created by lvjq20104 on 0017 2017/3/17.
 * 字符串处理工具
 */
public class StringUtil {
    /**
     * 校验邮箱
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (isEmpty(email)) return false;
        return email.matches("\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}");
    }

    /**
     * 校验手机号码
     *
     * @param mobile
     * @return
     */
    public static boolean isMobile(String mobile) {
        if (isEmpty(mobile)) return false;
        return mobile.matches("^1[3|4|5|7|8][0-9]\\d{4,8}$");
    }

    /**
     * 把null转换成空串
     *
     * @param str
     * @return
     */
    public static String blanknull(String str) {
        if (str != null) {
            return str;
        } else {
            return "";
        }
    }

    /**
     * 判断是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return Strings.isNullOrEmpty(str);
    }

    /**
     * 判断是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !Strings.isNullOrEmpty(str);
    }

    public static Integer String2Integer(String str, Integer def) {
        if (isEmpty(str)) {
            return def;
        } else {
            try {
                return Integer.valueOf(str.trim());
            } catch (Exception e) {
                return def;
            }
        }
    }

    public static Integer String2Integer(String str) {
        return String2Integer(str, 0);
    }

    public static Long String2Long(String str, Long def) {
        if (isEmpty(str)) {
            return def;
        } else {
            try {
                return Long.valueOf(str.trim());
            } catch (Exception e) {
                return def;
            }
        }
    }

    public static Long String2Long(String str) {
        return String2Long(str, 0l);
    }

    public static Float String2Float(String str, Float def) {
        if (isEmpty(str)) {
            return def;
        } else {
            try {
                return Float.valueOf(str.trim());
            } catch (Exception e) {
                return def;
            }
        }
    }

    public static Float String2Float(String str) {
        return String2Float(str, 0f);
    }

    public static Double String2Double(String str, Double def) {
        if (isEmpty(str)) {
            return def;
        } else {
            try {
                return Double.valueOf(str.trim());
            } catch (Exception e) {
                return def;
            }
        }
    }

    public static Double String2Double(String str) {
        return String2Double(str, 0d);
    }
}
