package com.zsc.museum.controller;

import com.zsc.museum.domain.Return;
import com.zsc.museum.mapper.ReturnMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class returnController {

    @Resource
    ReturnMapper returnMapper;

    @GetMapping("/returnDetails")
    public String returnDetails(Model model){
        List<Return> Rdetails=returnMapper.findAll();
        model.addAttribute("Rdetails", Rdetails);
        return "pages/ReturnInfo";
    }

    @GetMapping("/returnDelete/{returnId}")
    public String borrowDelete(@PathVariable Long returnId) {
        returnMapper.returnDelete(returnId);
        return "redirect:/returnDetails?result=1";
    }
}
