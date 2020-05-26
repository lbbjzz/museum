package com.zsc.museum.controller;
import com.zsc.museum.domain.Warehouse;
import com.zsc.museum.mapper.WarehouseMapper;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

//仓库类控制器
@Controller
public class WarehouseController {
    @Resource
    WarehouseMapper warehouseMapper;

    //仓库显示
    @GetMapping("/wareHouse")
    public String listwareHouse(Model model) {
        List<Warehouse> warehouseList=warehouseMapper.findAll();
        List<Warehouse> warehouse = warehouseMapper.FindtoPage(0);
        model.addAttribute("wareHouse", warehouse);
        model.addAttribute("num", warehouseList.size());
        return "pages/wareHouse";
    }
    @GetMapping("/findtowarehousePage")
    public String FindtoPage(Model model,Integer i) {
        List<Warehouse> warehouse = warehouseMapper.FindtoPage(i);
        List<Warehouse> warehouseList=warehouseMapper.findAll();
        model.addAttribute("wareHouse", warehouse);
        model.addAttribute("num", warehouseList.size());
        return "pages/wareHouse";
    }

    //仓库添加
    @GetMapping("/AddwareHouse")
    public String wareHouseAdd() {
        return "pages/wareHouseAdd";
    }

    @PostMapping("/AddwareHouse")
    public String createwareHouse(Warehouse warehouse) {
        warehouseMapper.Insert(warehouse);
        return "redirect:/wareHouse";
    }


    //编辑仓库
    @GetMapping("/wareHouseEdit/{id}")
    public String towareHouseEdit(@PathVariable Long id, Model model) {
        Warehouse warehouse = warehouseMapper.SelectOne(id);
        model.addAttribute("warehouse", warehouse);
        return "pages/wareHouseEdit";
    }
    @PostMapping("/updatewareHouse")
    public String wareHouseEdit(Warehouse warehouse) {
        warehouseMapper.update(warehouse);
        return "redirect:/wareHouse";
    }
    //删除仓库
    @GetMapping("/deletewareHouse/{id}")
    public String delete(@PathVariable Long id) {
        warehouseMapper.delete(id);
        //重定向到list URL
        return "redirect:/wareHouse";
    }
    //通过名字模糊查找
    @GetMapping("/selectbywarehousename")
    public String SelectByName(Model model, HttpServletRequest request) {
        String warehouse_name = request.getParameter("warehouse_name");
        List<Warehouse> warehouse = warehouseMapper.SelectByName(warehouse_name);
        model.addAttribute("warehouse", warehouse);
        return "pages/wareHouse";
    }









}
