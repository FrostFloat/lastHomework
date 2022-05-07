package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 由于boot默认没有web.xml因此无法配置使用servlet、Filter、Listener
 * 自定义servlet
 */
@WebServlet(name = "myServlet", urlPatterns = "/myServlet")
public class MyServlet {
    //使用 @WebServlet 注解声明一个 Servlet
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("Spring Boot Servlet");
        writer.close();
    }
}

