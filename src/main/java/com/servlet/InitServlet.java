package com.servlet;

import com.common.Cache;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by admin on 2018/2/7.
 */
public class InitServlet extends HttpServlet {
    Logger log = Logger.getLogger(InitServlet.class);

    public void init() throws ServletException {
        Cache.LoadAll();
    }
}
