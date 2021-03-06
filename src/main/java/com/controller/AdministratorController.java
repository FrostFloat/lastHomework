package com.controller;
/**
 * 管理员控制层
 * 注册 登录 修改信息
 */

import com.bean.Administrator;
import com.service.AdminServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdministratorController {
    @Autowired
    AdminServiceI adminServiceI;
    /*
     * 用户相关页面跳转
     */
    /*管理员注册页面*/
    @RequestMapping("/adminRegister")
    public String adminRegister(Model model){
        return "/administrator/register";
    }
    /*管理员登录页面*/
    @RequestMapping("/adminLogin")
    public String adminLogin(Model model){
        return "/administrator/login";
    }
    /*管理员管理页面*/
    @RequestMapping("/adminCenter")
    public String adminCenter(Model model){
        return "/administrator/adminCenter";
    }
    /*添加旅游产品页面*/
    @RequestMapping("/config/addTP")
    public String addTP(Model model){
        return "/administrator/config/addTP";
    }
    /*展示产品信息页面*/
    @RequestMapping("/config/displayTP")
    public String displayTP(Model model,HttpSession session){
        return "forward:/travelPackage/displayTP";
    }
    /*展示产品详细信息页面*/
    @RequestMapping("/displayTP")
    public String displayDetailedTP(Model model){
        return "forward:/travelPackage/admin/displayDetailedTP";
    }

    /*展示企业信息页面*/
    @RequestMapping("/config/displayImf")
    public String displayImf(Model model){
        return "/administrator/config/displayImf";
    }



    /*
     * 用户信息请求
     */
    @RequestMapping("/login")
    public String login(Model model, String adminAccount, String password, HttpSession session){
        System.out.println("controller----login");
        //获取密码
        String realPwd = adminServiceI.queryPwdByAdmin(adminAccount);
        //错误信息
        String actNullMsg = "账号不存在，请重新输入";
        String pwdErrorMsg = "密码不匹配，请重新输入";
        //判断账号是否存在
        if(realPwd == null){//如果密码不存在
            model.addAttribute("LoginMsg",actNullMsg);
            return "/administrator/login";
        }
        //打印信息
        System.out.println("adminAccount: " + adminAccount);
        System.out.println("password: " + password);
        System.out.println("realPwd: " + realPwd);

        //将匹配密码是否正确
        if(realPwd.equals(password)){//如果密码正确，跳转到索引页面
            //清除用户登陆状态
            if(session.getAttribute("User") != null){//如果用户登录
                System.out.println("用户下线");
                session.removeAttribute("User");
            }
            Administrator administrator = adminServiceI.query(adminAccount);
            System.out.println(adminAccount.toString());
            session.setAttribute("Admin",administrator);
            System.out.println("INFO----登录成功");
            //重定向到管理界面
            return "redirect:/admin/adminCenter";
        }else{//如果密码不正确，重新输入密码
            System.out.println("INFO----登陆失败");
            model.addAttribute("LoginMsg",pwdErrorMsg);
            return "/administrator/login";
        }
    }

    @RequestMapping("/register")
    public String register(Model model, Administrator administrator){
        System.out.println("controller----register");
        //错误信息
        String actExistMsg = "该电话号码已经存在,请更换电话号码";
        //判断电话号码是否重复 重复则重新输入
        if(adminServiceI.queryPwdByAdmin(administrator.getPhone()) != null){//如果账号已经存在
            model.addAttribute("RegisterMsg",actExistMsg);
            return "/administrator/register";
        }
        //自动补充空缺数据
        if(administrator.getIntroduce().isEmpty()){//如果介绍为空，则自动填入
            administrator.setIntroduce("介绍为空。。。。");
        }
        System.out.println(administrator.toString());
        //执行服务层函数
        adminServiceI.insert(administrator);
        return "/administrator/login";
    }

    @RequestMapping("/update")
    public String update(Model model, HttpSession session,Administrator administrator){
        System.out.println("controller----update");
        //补充缺失信息
        administrator.setId(((Administrator)session.getAttribute("Admin")).getId());
        //打印信息
        System.out.println(administrator.toString());
        //确认电话号码是否重复
        //更新数据
        adminServiceI.update(administrator);
        //更新session
        session.setAttribute("Admin",administrator);
        return "forward:/admin/config/displayImf";
    }

}
