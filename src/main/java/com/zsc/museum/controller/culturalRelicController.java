package com.zsc.museum.controller;

import com.zsc.museum.domain.Cultural_relic;
import com.zsc.museum.domain.Warehouse;
import com.zsc.museum.mapper.CulturalMapper;
import com.zsc.museum.mapper.WarehouseMapper;
import com.zsc.museum.service.CulturalRelicService;
import com.zsc.museum.service.StaffService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class culturalRelicController {
    String fileName;
    @Resource
    CulturalMapper culturalMapper;

    @Autowired
    public StaffService staffService;




    //单页显示文物
    @GetMapping("/culturalInfo")
    public String listCultural(Model model, HttpSession httpSession) {
        List<Cultural_relic> cultural_relics=culturalMapper.findAll();
        model.addAttribute("cultural", cultural_relics);

        String a = staffService.selectstatus(1);
        httpSession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/CulturalRelicsInfo";
        }

    }

    @GetMapping("/findFirstPage")
    public String findtoPage(Model model,Integer i,HttpSession httpSession) {
        List<Cultural_relic> cultural = culturalMapper.FindtoPage(0);
        List<Cultural_relic> cultural_relics=culturalMapper.findAll();
        model.addAttribute("cultural", cultural);
        model.addAttribute("num", cultural_relics.size());

        String a = staffService.selectstatus(1);
        httpSession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/CulturalRelicsInfo";
        }

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
    public String detail(@PathVariable Long id, Model model,HttpSession httpSession) {
        Cultural_relic cultural_relic = culturalMapper.SelectOne(id);
        model.addAttribute("cultural_relic", cultural_relic);


        String a = staffService.selectstatus(1);
        httpSession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/CulturalRelicsDetails";
        }

    }

    //编辑文物
    @GetMapping("/edit/{id}")
    public String toCulturalEdit(@PathVariable Long id, Model model,HttpSession httpSession) {
        Cultural_relic cultural_relic = culturalMapper.SelectOne(id);
        model.addAttribute("cultural_relic", cultural_relic);
        List<Warehouse> warehouses = culturalMapper.findAllWareHouse();
        model.addAttribute("warehouses", warehouses);


        String a = staffService.selectstatus(1);
        httpSession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/CulturalRelicsEdit";
        }

    }


    //更新文物
    @PostMapping("/update")
    public String CulturalEdit(Cultural_relic relic) {
        culturalMapper.update(fileName,relic);
        return "redirect:/culturalInfo?result=1";
    }

    @GetMapping("/culturalEntry")
    public String culturalEntry(Model model) {
        List<Warehouse>warehouses=culturalMapper.findAllWareHouse();
        model.addAttribute("warehouses", warehouses);
        return "pages/CulturalRelicsEntry";
    }

    //文物添加
    @PostMapping("/createcultural")
    public String createcultural(Cultural_relic cultural_relic) {
        culturalMapper.Insert(fileName,cultural_relic);
        return "redirect:/culturalInfo?result=1";
    }

    //文物删除
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        culturalMapper.delete(id);
        //重定向到list URL
        return "redirect:/culturalInfo?result=1";
    }

    //通过名字模糊查找
    @GetMapping("/selectbyname")
    public String SelectByName(Model model, HttpServletRequest request,HttpSession httpSession) {
        String name = request.getParameter("name");
        List<Cultural_relic> cultural = culturalMapper.SelectByName(name);
        model.addAttribute("cultural", cultural);

        String a = staffService.selectstatus(1);
        httpSession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/CulturalRelicsInfo";
        }

    }

    @PostMapping("/ajaxUploadFile")
    @ResponseBody
    public Map<String, Object> ajaxUploadFile(MultipartFile[] files){
        Map<String, Object> map=new HashMap<>();
        for(MultipartFile file:files){
            fileName = file.getOriginalFilename();
//            String path = System.getProperty("user.dir");
//            String dirPath = path+"/src/main/resources/static/cultural/";


            ApplicationHome h = new ApplicationHome(getClass());
            File jarF = h.getSource();
            String dirPath = jarF.getParentFile().toString()+"/upload/";
            System.out.println(dirPath);


            File filePath = new File(dirPath);
            if(!filePath.exists()){
                filePath.mkdirs();
            }
            try{
                file.transferTo((new File(dirPath+fileName)));
                map.put("msg","上传成功！");
            }catch (Exception e){
                e.printStackTrace();
                map.put("msg","上传失败！");
            }
        }
        return map;
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
