package com.zsc.museum.controller;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.Session;
import java.io.File;

@Controller
public class GetPathController {
    @RequestMapping("/getPath")
    @ResponseBody
    public String getPath(){
        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        String path = jarF.getParentFile().toString();
        System.out.println(jarF.getParentFile().toString());


        return path;
    }


    @RequestMapping("/getImage")

    public String getImage(Model model){
//        ApplicationHome h = new ApplicationHome(getClass());
//        File jarF = h.getSource();
//        String path = jarF.getParentFile().toString();
//        System.out.println(jarF.getParentFile().toString());
//        model.addAttribute("path",path);

        return "getImage/getImage";
    }
}
