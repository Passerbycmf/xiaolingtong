package com.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by lvjianqing on 2017/7/27.
 * 读取config.properties配置文件
 */
public final class Config {

    private static Log log = LogFactory.getLog(Config.class);

    private Config() {

    }

    private static Properties props = new Properties();

    static {
        try {
            String path = Config.class.getClassLoader().getResource("").getPath();
            props.load(new FileInputStream(path + "config.properties"));
            //props.load(new InputStreamReader(new FileInputStream(path + "config.properties"), "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    private static boolean changeToBoolean(String str) {
        String tmp = str.toLowerCase();
        if (tmp.equals("true")) {
            return true;
        } else if (tmp.equals("false")) {
            return false;
        } else {
            throw new RuntimeException("class not matching.");
        }
    }

    public static boolean getBoolean(String key) {
        String str = Config.getString(key);
        try {
            return Config.changeToBoolean(str);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        String str = Config.getString(key);
        try {
            return Config.changeToBoolean(str);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    private static int changeToInt(String str) throws Exception {
        return Integer.parseInt(str);
    }

    public static int getInt(String key) {
        String str = Config.getString(key);
        try {
            return Config.changeToInt(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getInt(String key, int defaultValue) {
        String str = Config.getString(key);
        try {
            return Config.changeToInt(str);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static String getString(String key, String defaultValue) {

        String tmp = getString(key);
        if (tmp == null) {
            tmp = defaultValue;
        }
        log.debug(key + ": " + tmp);
        return tmp;
    }

    private static String getRealValue(String valueStr) {
        if (valueStr != null) {
            String rtnValue = valueStr;
            while (valueStr.indexOf("${") >= 0 && valueStr.indexOf("}") >= 0) {
                String keyName = valueStr.substring(valueStr.indexOf("{") + 1,
                    valueStr.indexOf("}"));
                rtnValue = getString(keyName, "") + valueStr.substring(valueStr.indexOf("}") + 1);
            }
            return rtnValue;
        } else
            return null;
    }

    public static String getString(String key) {
        String tmp = getRealValue(props.getProperty(key));
        log.debug(key + ": " + tmp);
        return tmp;
    }
}
