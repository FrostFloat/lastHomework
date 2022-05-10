package com.controller;
/**
 * 旅游套餐控制层
 * 增加 修改 删除
 * 获取对应公司的旅游套餐
 *
 */

import com.bean.Administrator;
import com.bean.Index;
import com.bean.TravelPackage;
import com.service.TravelPackageServiceI;
import com.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/travelPackage")
public class TravelPackageController {
    @Autowired
    TravelPackageServiceI travelPackageServiceI;
    @Value("${tp-img-path}")
    private String path;
    /*
     * 产品相关页面跳转
     */
    @RequestMapping("/config/uploadImg")
    public String uploadImg(Model model){
        return "/data/operation/uploadImg";
    }

    /*
     * 产品信息请求
     */
    @RequestMapping("/insert")
    public String addTP(Model model, TravelPackage travelPackage, MultipartFile file, HttpSession session) throws IOException {
        System.out.println("controller----insert");
        //补充未填写的数据
        travelPackage.setCompany(((Administrator)session.getAttribute("Admin")).getName());//填写公司名称
        if(travelPackage.getSummary() == null){
            travelPackage.setSummary("null");
        }
        //保存图片到本地
        if(file != null){
            travelPackage.setImgLocation(ImageUtil.saveLocal(file));
        }
        else
            System.out.println("INFO----没有上传图片");

        //打印信息
        System.out.println(travelPackage.toString());
        //插入到数据库中
        travelPackageServiceI.insert(travelPackage);
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
    @RequestMapping("/admin/displayDetailedTP")
    public String displayAdminDetailedTP(Model model, HttpServletRequest request){
        System.out.println("controller----displayAdminDetailedTP");
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
    @RequestMapping("/user/displayDetailedTP")
    public String displayUserDetailedTP(Model model, HttpServletRequest request){
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

        return "/data/userData";
    }
    @RequestMapping("updateTP")
    public String updateTP(Model model,TravelPackage travelPackage){
        System.out.println("controller----updateTP");
        //打印信息
        System.out.println(travelPackage.toString());
        //操作数据库
        travelPackageServiceI.updateById(travelPackage);
        return "forward:/admin/config/displayTP";
    }
    @RequestMapping("deleteTP")
    public String deleteTP(Model model, HttpServletRequest request){
        System.out.println("controller----deleteTP");
        //获取id
        String id = request.getParameter("id");
        //打印信息
        System.out.println("id: " + id);
        //操作数据库
        travelPackageServiceI.deleteById(id);
        return "forward:/admin/config/displayTP";
    }
    @RequestMapping("/uploadImg")
    public String test(Model model, MultipartFile file) throws IOException {
        //保存图片到本地
        if(file != null){
            ImageUtil.saveLocal(file);
        }
        else
            System.out.println("INFO----没有上传图片");
        return "/administrator/config/displayTP";
    }
    @RequestMapping("/index")
    public String index(Model model){
        System.out.println("controller----index");
        //获取所有的产品
        List<Index> indexList = travelPackageServiceI.queryIndex();
        //打印信息
        System.out.println(indexList.toString());
        //存入model中
        model.addAttribute("Indexes",indexList);
        return "/index";
    }
}
