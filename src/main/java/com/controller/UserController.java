package com.controller;

/**
 * 用户信息控制层
 * 注册 登录 退出 修改
 */

import com.bean.User;
import com.service.UserServiceI;
import com.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceI userServiceI;

    /*
     * 用户相关页面跳转
     */
    /*注册界面*/
    @RequestMapping("/userRegister")
    public String index(Model model){
        return "/user/register";
    }
    /*登录界面*/
    @RequestMapping("/userLogin")
    public String userLogin(Model model){//尚未输入账号密码
        return "/user/login";
    }
    /*用户中心*/
    @RequestMapping("/userCenter")
    public String userCenter(Model model){
        return "/user/userCenter";
    }
    /*用户中心————展示个人信息*/
    @RequestMapping("/config/displayImf")
    public String displayImf(Model model){
        return "/user/config/displayImf";
    }
    /*用户中心————订单信息*/
    @RequestMapping("/config/order")
    public String order(Model model){
        return "/user/config/order";
    }
    /*用户中心————资产信息*/
    @RequestMapping("/config/assets")
    public String assets(Model model){
        return "/user/config/assets";
    }

    /*
     * 用户信息请求
     */
    /*注册*/
    @RequestMapping("/register")
    public String register(Model model, User user){
        //判断电话号码是否重复 重复则重新输入

        //如果昵称为空 自动给一个
        if(user.getNickName().isEmpty())
            user.setNickName("新用户"+ RandomUtil.number(6));
        //打印信息
        System.out.println("controller----insert");
        System.out.println(user.toString());
        //插入
        userServiceI.insert(user);
        //跳转到登录界面
        return "/user/login";
    }

    @RequestMapping("/login")
    public String login(Model model, String userAccount, String password, HttpSession session){//已经输入账号密码
        //获取密码
        String realPwd = userServiceI.queryPwdByUser(userAccount);
        String loginMsg = "账号错误或密码不匹配，请重新输入";
        //打印信息
        System.out.println("controller----login");
        System.out.println("userAccount: " + userAccount);
        System.out.println("password: " + password);
        System.out.println("realPwd: " + realPwd);
        //将匹配密码是否正确
        if(realPwd.equals(password)){//如果密码正确，跳转到索引页面
            //清除管理员登录状态
            if(session.getAttribute("Admin") != null){//如果管理员登录
                System.out.println("管理员下线");
                session.removeAttribute("Admin");
            }
            User user = userServiceI.query(userAccount);
            System.out.println(user.toString());
            session.setAttribute("User",user);
            System.out.println("INFO----登录成功");
            return "redirect:/shop/index";
        }else{//如果密码不正确，重新输入密码
            System.out.println("INFO----登陆失败");
            model.addAttribute("LoginMsg",loginMsg);
            return "/user/login";
        }
    }

    @RequestMapping("/exit")
    public String exit(Model model, HttpSession session){//已经输入账号密码
        //获取密码
        System.out.println("controller----Exit");
        //清除session中的用户信息
        session.removeAttribute("User");
        //判断是否退出
        if (session.getAttribute("User") == null){
            System.out.println("INFO----退出成功");
        }
        return "redirect:/shop/index";
    }

    @RequestMapping("/update")
    public String update(Model model, HttpSession session,User user){
        //存储信息
        user.setId(((User)session.getAttribute("User")).getId());
        //打印信息
        System.out.println("controller----update");
        System.out.println(user.toString());
        //检查电话号码是否已经存在

        //更新数据库信息
        userServiceI.updateById(user);
        //更新session信息
        session.setAttribute("User",user);
        return "redirect:/user/config/displayImf";
    }

}
