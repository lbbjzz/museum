package com.zsc.museum.controller;
import com.zsc.museum.domain.Staff;
import com.zsc.museum.mapper.StaffMapper;
import com.zsc.museum.service.StaffService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;
//用户管理类控制器

@Controller
public class StaffController {
    @Resource
    StaffMapper staffMapperMapper;



    @Autowired
    public StaffService staffService;


    //登录
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(Model model) {
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "/login";
    }

    @RequestMapping(value = "/loginPage", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(HttpServletRequest request, HttpSession session) {
        String number = request.getParameter("number");
        String password = request.getParameter("password");
        //System.out.println("你输入的用户名为：" + number);
        //System.out.println("你输入的密码为：" + password);
        String tname = staffService.login(number, password);
        session.setAttribute("tname", tname);
        if (tname == null) {
            return "redirect:/";
        } else {
            return "redirect:/takePhoto";
        }
    }

    @RequestMapping(value = "/takePhoto", method = {RequestMethod.POST, RequestMethod.GET})
    public String loginindex() {
        return "pages/takePhoto";
    }


    //拍照
    @GetMapping("/photo")
    public String photoStaff(Model model) {
        return "pages/photo";
    }

    //文物估值
    @GetMapping("/estimate")
    public String estimate(Model model) {
        return "pages/estimate";
    }



    //查看用户

    @GetMapping("/employees")
    public String listStaff(Model model) {
        List<Staff> staffList=staffMapperMapper.findAll();
        List<Staff> staff = staffMapperMapper.FindtoPage(0);
        model.addAttribute("Staff", staff);
        model.addAttribute("num", staff.size());
        return "pages/employees";
    }
    @GetMapping("/findtostaffPage")
    public String FindtoPage(Model model,Integer i) {
        List<Staff> staff = staffMapperMapper.FindtoPage(i);
        List<Staff> staffList=staffMapperMapper.findAll();
        model.addAttribute("Staff", staff);
        model.addAttribute("num", staffList.size());
        return "pages/employees";
    }
    //增加用户

    @GetMapping("/AddStaff")
    public String StaffAdd() {
            return "pages/employeesAdd";
        }

    @PostMapping("/AddStaff")
    public String createStaff(Staff staff) {
        staffMapperMapper.Insert(staff);
        return "redirect:/employees";
    }

    //删除用户

    @GetMapping("/deletestaff/{id}")
    public String delete(@PathVariable Long id) {
        staffMapperMapper.delete(id);
        //重定向到list URL
        return "redirect:/employees";
    }


    //编辑用户

    @GetMapping("/employeesEdit/{id}")
    public String toemployeesEdit(@PathVariable Long id, Model model) {
        Staff staff = staffMapperMapper.SelectOne(id);
        model.addAttribute("Staff", staff);
        return "pages/employeesEdit";
    }
    @PostMapping("/updateemployees")
    public String employeesEdit(Staff staff) {
        staffMapperMapper.update(staff);
        return "redirect:/employees";
    }


    //通过名字模糊查找
    @GetMapping("/selectbystaffname")
    public String SelectByName(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        List<Staff> staff = staffMapperMapper.SelectByName(name);
        model.addAttribute("Staff", staff);
        return "pages/employees";
    }


}
