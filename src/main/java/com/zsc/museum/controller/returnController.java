package com.zsc.museum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class returnController {
    @GetMapping("/returnDetails")
    public String returnDetails(){
        return "pages/ReturnInfo";
    }
}
