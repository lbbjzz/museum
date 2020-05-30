package com.zsc.museum.controller;

import com.zsc.museum.domain.Cultural_relic;
import com.zsc.museum.mapper.CulturalMapper;
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

@Controller
public class culturalRelicController {
    @Resource
    CulturalMapper culturalMapper;

    //单页显示文物
    @GetMapping("/culturalInfo")
    public String listCultural(Model model) {
        List<Cultural_relic> cultural_relics=culturalMapper.findAll();
        model.addAttribute("cultural", cultural_relics);
        return "pages/CulturalRelicsInfo";
    }

    @GetMapping("/findFirstPage")
    public String findtoPage(Model model,Integer i) {
        List<Cultural_relic> cultural = culturalMapper.FindtoPage(0);
        List<Cultural_relic> cultural_relics=culturalMapper.findAll();
        model.addAttribute("cultural", cultural);
        model.addAttribute("num", cultural_relics.size());
        return "pages/CulturalRelicsInfo";
    }

    @GetMapping("/findtoPage")
    public String FindtoPage(Model model,Integer i) {
        List<Cultural_relic> cultural = culturalMapper.FindtoPage(i);
        List<Cultural_relic> cultural_relics=culturalMapper.findAll();
        model.addAttribute("cultural", cultural);
        model.addAttribute("num", cultural_relics.size());
        return "pages/CulturalRelicsInfo";
    }

    //文物详情
    @GetMapping("/details/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Cultural_relic cultural_relic = culturalMapper.SelectOne(id);
        model.addAttribute("cultural_relic", cultural_relic);
        return "pages/CulturalRelicsDetails";
    }

    //编辑文物
    @GetMapping("/edit/{id}")
    public String toCulturalEdit(@PathVariable Long id, Model model) {
        Cultural_relic cultural_relic = culturalMapper.SelectOne(id);
        model.addAttribute("cultural_relic", cultural_relic);
        return "pages/CulturalRelicsEdit";
    }


    //更新文物
    @PostMapping("/update")
    public String CulturalEdit(Cultural_relic relic) {
        culturalMapper.update(relic);
        return "redirect:/culturalInfo";
    }

    @GetMapping("/culturalEntry")
    public String culturalEntry() {
        return "pages/CulturalRelicsEntry";
    }

    //文物添加
    @PostMapping("/createcultural")
    public String createcultural(Cultural_relic cultural_relic) {
        culturalMapper.Insert(cultural_relic);
        return "redirect:/culturalInfo";
    }

    //文物删除
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        culturalMapper.delete(id);
        //重定向到list URL
        return "redirect:/culturalInfo";
    }

    //通过名字模糊查找
    @GetMapping("/selectbyname")
    public String SelectByName(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        List<Cultural_relic> cultural = culturalMapper.SelectByName(name);
        model.addAttribute("cultural", cultural);
        return "pages/CulturalRelicsInfo";
    }
    //导出到Excel表
    @GetMapping("/export.xls")
    public void downLoadToExcel(OutputStream outputStream) {
        //文档对象
        List<Cultural_relic>cultural_relicslist=culturalMapper.findAll();
        HSSFWorkbook wb = new HSSFWorkbook();
        int rowNum = 0;
        Sheet sheet = wb.createSheet();
        Row row0 = sheet.createRow(rowNum++);
        row0.createCell(0).setCellValue("id");
        row0.createCell(1).setCellValue("name");
        row0.createCell(2).setCellValue("number");
        row0.createCell(3).setCellValue("material");
        row0.createCell(4).setCellValue("age");
        row0.createCell(5).setCellValue("reign_title");
        row0.createCell(6).setCellValue("source");
        row0.createCell(7).setCellValue("size");
        if (cultural_relicslist != null && cultural_relicslist.size() > 0) {
            for (Cultural_relic cultural_relic: cultural_relicslist) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(cultural_relic.getId());
                row.createCell(1).setCellValue(cultural_relic.getName());
                row.createCell(2).setCellValue(cultural_relic.getNumber());
                row.createCell(3).setCellValue(cultural_relic.getMaterial());
                row.createCell(4).setCellValue(cultural_relic.getAge());
                row.createCell(5).setCellValue(cultural_relic.getTitle());
                row.createCell(6).setCellValue(cultural_relic.getSource());
                row.createCell(7).setCellValue(cultural_relic.getSize());
            }
            // 处理中文不能自动调整列宽的问题
            sheet.setDefaultColumnWidth(20);
        }
        try {
            wb.write(outputStream);
            System.out.println("表数据写入到excel表成功,一共写入了"+(rowNum - 1)+"条数据");
            outputStream.close();
        } catch (IOException e) {
            System.out.println("流关闭异常！");
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.out.println("流关闭异常！");
                }
            }
        }
    }
}