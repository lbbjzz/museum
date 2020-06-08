package com.zsc.museum.controller;
import com.zsc.museum.domain.Staff;
import com.zsc.museum.mapper.StaffMapper;
import com.zsc.museum.service.CulturalRelicService;
import com.zsc.museum.service.StaffService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;
//用户管理类控制器
//操作成功返回result=1

@Controller
public class StaffController {
    @Resource
    StaffMapper staffMapperMapper;



    @Autowired
    public StaffService staffService;


    @Autowired
    public CulturalRelicService culturalService;

    //登录
    @RequestMapping(value = "/tologin", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(Model model) {
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }



    @RequestMapping(value = "/loginPage", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(HttpServletRequest request, HttpSession session) {
        String number = request.getParameter("number");
        String password = request.getParameter("password");
        String tname = staffService.login(number, password);

        session.setAttribute("tname", tname);


        if (tname == null) {
            return "redirect:/tologin?error";
        } else {
            staffService.status(1, 1);
            return "redirect:/findFirstPage";
        }
    }

    //拍照并把照片名称存入数据库
    @RequestMapping(value = "/photosave", method = {RequestMethod.POST, RequestMethod.GET})
    public String imgFileName(HttpServletRequest request,HttpSession httpsession) {
        String imgId = request.getParameter("imgId");
        String imgFileName="cultural"+imgId+".png";

        culturalService.imgFileName(imgFileName,imgId);


        String a = staffService.selectstatus(1);
        httpsession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/photoEdit";
        }


    }



    //估值
    @RequestMapping(value = "/estimateEdit", method = {RequestMethod.POST, RequestMethod.GET})
    public String value(HttpServletRequest request,HttpSession httpsession) {
        String id = request.getParameter("id");
        String price = request.getParameter("price");

        culturalService.value(price,id);


        String a = staffService.selectstatus(1);
        httpsession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/estimateEdit";
        }
    }





    //查看用户
    @GetMapping("/employees")
    public String listStaff(Model model,HttpSession httpsession) {
        List<Staff> staff=staffMapperMapper.findAll();
        model.addAttribute("Staff", staff);

        String a = staffService.selectstatus(1);
        httpsession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/employees";
        }

    }

    //增加用户
    @GetMapping("/AddStaff")
    public String StaffAdd(HttpSession httpsession) {

        String a = staffService.selectstatus(1);
        httpsession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/employeesAdd";
        }

    }

    @PostMapping("/createStaff")
    public String createStaff(Staff staff,HttpSession httpsession) {
        staffMapperMapper.Insert(staff);

        String a = staffService.selectstatus(1);
        httpsession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "redirect:/employees?result=1";
        }

    }
    //删除用户
    @GetMapping("/deleteemployee/{id}")
    public String delete(@PathVariable Long id,HttpSession httpsession) {
        staffMapperMapper.delete(id);
        //重定向到list URL


        String a = staffService.selectstatus(1);
        httpsession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "redirect:/employees?result=1";
        }

    }

    @GetMapping("/editemployee/{id}")
    public String toemployeesEdit(@PathVariable Long id, Model model,HttpSession httpsession) {
        Staff staff = staffMapperMapper.SelectOne(id);
        model.addAttribute("Staff", staff);


        String a = staffService.selectstatus(1);
        httpsession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/employeesEdit";
        }

    }

    @PostMapping("/updateemployee")
    public String employeesEdit(Staff staff,HttpSession httpsession) {
        staffMapperMapper.update(staff);

        String a = staffService.selectstatus(1);
        httpsession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "redirect:/employees?result=1";
        }



    }

    //通过名字模糊查找
    @GetMapping("/selectbystaffname")
    public String SelectByName(Model model, HttpServletRequest request,HttpSession httpsession) {
        String name = request.getParameter("name");
        List<Staff> staff = staffMapperMapper.SelectByName(name);
        model.addAttribute("Staff", staff);

        String a = staffService.selectstatus(1);
        httpsession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/employees";
        }

    }


}
