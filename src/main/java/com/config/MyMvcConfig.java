package com.config;
/**
 * SpringMvc配置类
 *
 * 添加登录拦截类到配置中
 */

import com.interceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyMvcConfig implements WebMvcConfigurer {
    /*添加登录拦截类到配置中*/
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**") //拦截所有请求，包括静态资源文件
                .excludePathPatterns("/shop/index", "/user/**", "/css/**", "/images/**", "/javascript/**"); //放行登录页，登陆操作，静态资源
    }
}
