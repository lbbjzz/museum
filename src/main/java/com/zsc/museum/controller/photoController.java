package com.zsc.museum.controller;

import com.zsc.museum.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


@RestController
public class photoController {


    @Autowired
    public StaffService staffService;
    @RequestMapping(value = "/photosavedemo", method = RequestMethod.POST)
    @ResponseBody

    public Map<String, Object> photosavedemo(@RequestParam("file") MultipartFile images, HttpServletRequest request) {

        String imgId = request.getParameter("imgId");
        String imgFileName = "cultural" + imgId + ".png";

        Map<String, Object> map = new HashMap<>();

//        String path = System.getProperty("user.dir");
//        String dirPath = path + "/src/main/resources/static/cultural/";


        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        String dirPath = jarF.getParentFile().toString()+"/upload/";
        //System.out.println(dirPath);

        //System.out.println(images);
        File filePath = new File(dirPath);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        try {
            images.transferTo((new File(dirPath + imgFileName)));
            map.put("msg", "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "失败！");
        }
        return map;
    }


    @RequestMapping(value = "/status", method = {RequestMethod.POST, RequestMethod.GET})
    public String imgFileName(HttpSession httpsession) {
        String a = staffService.status(0,1);
        return "redirect:/tologin";

    }

}
