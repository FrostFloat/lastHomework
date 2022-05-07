package com.controller;
/**
 * 旅游套餐控制层
 * 增加 修改 删除
 * 获取对应公司的旅游套餐
 *
 */

import com.bean.Administrator;
import com.bean.TravelPackage;
import com.service.TravelPackageServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/travelPackage")
public class TravelPackageController {
    @Autowired
    TravelPackageServiceI travelPackageServiceI;
    @Value("${tp-img-path}")
    private String path;
    /*
     * 用户相关页面跳转
     */

    /*
     * 用户信息请求
     */
    @RequestMapping("insert")
    public String addTP(Model model, TravelPackage travelPackage, MultipartFile imgFile, HttpSession session){
        //补充未填写的数据
        travelPackage.setCompany(((Administrator)session.getAttribute("Admin")).getName());//填写公司名称
        //保存图片到本地
        File filePath = new File(path);
        System.out.println("文件保存路径: " + path);
        if(!filePath.exists()){
            System.out.println("目录不存在");
        }

        //检查数据

        //打印信息
        System.out.println("controller----insert");
        System.out.println(travelPackage.toString());
        //插入到数据库中
        travelPackageServiceI.insert(travelPackage);
        return "/administrator/config/addTP";
    }
    @RequestMapping("update")
    public String update(Model model, TravelPackage travelPackage, HttpSession session){

        return "/administrator/config/addTP";
    }
    @RequestMapping("delete")
    public String delete(Model model, TravelPackage travelPackage, HttpSession session){

        return "/administrator/config/addTP";
    }

    @RequestMapping("displayTP")
    public String displayTP(Model model,HttpSession session){
        //检查数据

        //打印信息
        System.out.println("controller----displayTP");
        //从数据库中获取信息
        List<TravelPackage> travelPackages = travelPackageServiceI.queryByCom(((Administrator)session.getAttribute("Admin")).getName());
        System.out.println(travelPackages.toString());
        //插入到model中

        session.setAttribute("TravelPackages",travelPackages);
        //System.out.println(session.getAttribute("TravelPackages"));
        return "/administrator/config/displayTP";
    }
    @RequestMapping("displayDetailedTP")
    public String displayDetailedTP(Model model, HttpServletRequest request){
        System.out.println("controller----displayDetailedTP");
        //获取id
        String id = request.getParameter("id");
        //根据id查询对应的产品信息
        TravelPackage travelPackage = travelPackageServiceI.queryById(id);
        //打印信息
        System.out.println("id: " + id);
        System.out.println(travelPackage.toString());
        //存储到model
        model.addAttribute("detail",travelPackage);

        return "/data/adminData";
    }
}
