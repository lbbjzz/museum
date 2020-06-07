package com.zsc.museum.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


@RestController
public class photoController {

    @RequestMapping(value = "/photosavedemo", method = RequestMethod.POST)
    @ResponseBody

    public Map<String, Object> photosavedemo(@RequestParam("file") MultipartFile images, HttpServletRequest request) {

        String imgId = request.getParameter("imgId");
        String imgFileName = "cultural" + imgId + ".png";

        Map<String, Object> map = new HashMap<>();

        String path = System.getProperty("user.dir");
        String dirPath = path + "/src/main/resources/static/cultural/";
        System.out.println(images);
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

}
