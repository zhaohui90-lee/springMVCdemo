package com.melody.util.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: melody
 * @Date: 2020-04-02
 */
public class PrimitiveServlet implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init...");
    }


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("from service");
        PrintWriter out = res.getWriter();
        out.println("hello...");
        out.print("Violet id blue");
    }


    @Override
    public String getServletInfo() {
        return null;
    }


    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
