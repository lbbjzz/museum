package com.zsc.museum.controller;
import com.zsc.museum.domain.Warehouse;
import com.zsc.museum.mapper.WarehouseMapper;
import com.zsc.museum.service.StaffService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

//仓库类控制器
@Controller
public class WarehouseController {

    @Resource
    WarehouseMapper warehouseMapper;

    @Autowired
    public StaffService staffService;

    //仓库显示
    @GetMapping("/wareHouse")
    public String listWarehouse(Model model, HttpSession httpSession) {
        List<Warehouse> warehouse=warehouseMapper.findAll();
        model.addAttribute("warehouse", warehouse);

        String a = staffService.selectstatus(1);
        httpSession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/wareHouse";
        }

    }

    //仓库添加
    @GetMapping("/toAddWarehouse")
    public String wareHouseAdd() {
        return "pages/wareHouseAdd";
    }

    @PostMapping("/addWarehouse")
    public String createWarehouse(Warehouse warehouse) {
        warehouseMapper.Insert(warehouse);
        return "redirect:/wareHouse";
    }


    //编辑仓库
    @GetMapping("/wareHouseEdit/{id}")
    public String toWarehouseEdit(@PathVariable Long id, Model model) {
        Warehouse warehouse = warehouseMapper.SelectOne(id);
        model.addAttribute("warehouse", warehouse);
        return "pages/wareHouseEdit";
    }

    @PostMapping("/updateWareHouse")
    public String wareHouseEdit(Warehouse warehouse) {
        warehouseMapper.update(warehouse);
        return "redirect:/wareHouse";
    }

    //删除仓库
    @GetMapping("/deleteWareHouse/{id}")
    public String delete(@PathVariable Long id) {
        warehouseMapper.delete(id);
        //重定向到list URL
        return "redirect:/wareHouse?result=1";
    }

    //通过名字模糊查找
    @GetMapping("/selectByWareHouseName")
    public String SelectByName(Model model, HttpServletRequest request) {
        String warehouseName = request.getParameter("warehouseName");
        List<Warehouse> warehouse = warehouseMapper.SelectByName(warehouseName);
        model.addAttribute("warehouse", warehouse);
        return "pages/wareHouse";
    }









}
