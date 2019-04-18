package com.common;

import java.lang.reflect.Field;

/**
 * Created by admin on 2018/2/7.
 */

public class Print {
    public String toString() {
        StringBuffer sb = new StringBuffer();
        try {
            Class c = this.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
            }
            for (Field f : fields) {
                String field = f.toString().substring(f.toString().lastIndexOf(".") + 1);         //取出属性名称
                if (!field.equals("serialVersionUID")) {
                    sb.append(field + ":" + f.get(this) + "|");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
