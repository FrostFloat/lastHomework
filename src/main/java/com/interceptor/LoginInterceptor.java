package com.interceptor;
/**
 * 定义登录拦截类
 * 没有登录时访问页面会自动跳转到对应的页面————尚未实现
 */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userLogin = request.getSession().getAttribute("userLogin");
        if (userLogin == null) {
            //未登录，返回登陆页
            request.setAttribute("msg", "您没有权限进行此操作，请先登陆！");
            request.getRequestDispatcher("/user/userLogin").forward(request, response);
            return false;
        } else {
            //放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor----postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginInterceptor----afterCompletion");
    }
}
