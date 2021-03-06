package com.melody.util.servlet;

import com.melody.util.constants.Constants;

import javax.servlet.Servlet;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * @Author: melody
 * @Date: 2020-04-02
 */
public class ServletProcessor {
    public void process(MyRequest request,MyResponse response){
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        URLClassLoader loader = null;
        try {
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(Constants.WEB_ROOT);

            String repository = (new URL("file",null,classPath.getCanonicalPath() + File.separator)).toString();
            urls[0] = new URL(null,repository,streamHandler);
            loader = new URLClassLoader(urls);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Class myClass = null;
        try {
            myClass = loader.loadClass(servletName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Servlet servlet;
        try {
            servlet = (Servlet) myClass.getDeclaredConstructor().newInstance();
            servlet.service(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
