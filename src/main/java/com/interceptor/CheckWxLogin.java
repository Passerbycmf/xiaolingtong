package com.interceptor;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/9/29.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckWxLogin {
    public String name();

    public String success() default "";

    public String failed() default "";
}
