package com.controller;
/**
 * 索引页控制层
 * 1、用户的登录
 * 2、轮播图图片的切换
 * 3、人们商品的改变
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class IndexController {
    /*
     * 页面跳转
     */
    /*跳转到产品索引界面*/
    @RequestMapping("/index")
    public String index(Model model){
        return "forward:/travelPackage/index";
    }

}
