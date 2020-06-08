package com.zsc.museum.controller;

import com.zsc.museum.domain.Return;
import com.zsc.museum.mapper.ReturnMapper;
import com.zsc.museum.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class returnController {

    @Resource
    ReturnMapper returnMapper;

    @Autowired
    public StaffService staffService;

    @GetMapping("/returnDetails")
    public String returnDetails(Model model, HttpSession httpSession){
        List<Return> Rdetails=returnMapper.findAll();
        model.addAttribute("Rdetails", Rdetails);


        String a = staffService.selectstatus(1);
        httpSession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/ReturnInfo";
        }

    }

    @GetMapping("/returnDelete/{returnId}")
    public String borrowDelete(@PathVariable Long returnId) {
        returnMapper.returnDelete(returnId);
        return "redirect:/returnDetails?result=1";
    }

    //通过文物ID模糊查找
    @GetMapping("/ByCulturalRelicId")
    public String SelectByBorrowId(Model model, HttpServletRequest request,HttpSession httpSession) {
        String culturalRelicId = request.getParameter("culturalRelicId");
        List<Return> Rdetails = returnMapper.SelectByCulturalRelicId(culturalRelicId);
        model.addAttribute("Rdetails", Rdetails);


        String a = staffService.selectstatus(1);
        httpSession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/ReturnInfo";
        }
    }
}
