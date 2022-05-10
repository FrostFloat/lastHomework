package com.controller;

import com.bean.Order;
import com.bean.User;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.service.OrderServiceI;
import com.service.TravelPackageServiceI;
import com.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderServiceI orderServiceI;
    @Autowired
    TravelPackageServiceI travelPackageServiceI;

    @RequestMapping("/buy")
    public String buy(Model model, HttpServletRequest request, HttpSession session){
        System.out.println("controller----buy");
        //获取商品id
        String tpId = request.getParameter("id");
        //获取用户id
        int uId = ((User) session.getAttribute("User")).getId();
        //封装信息
        Order order = new Order();
        order.setTpId(Integer.parseInt(tpId));
        order.setuId(uId);
        order.setoDate(TimeUtil.getCurrentTime());
        //检查是否有剩余
        int last = travelPackageServiceI.queryAmountById(Integer.parseInt(tpId));

        if(last>=1){
            System.out.println("INFO----商品充足,购买成功");
            orderServiceI.insert(order);
            travelPackageServiceI.updateAmountById(Integer.parseInt(tpId),last-1);
            return "/user/userCenter";
        }
        return "redirect:/shop/index";
    }
}
