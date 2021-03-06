package com.zsc.museum.controller;

import com.zsc.museum.domain.Borrow;
import com.zsc.museum.domain.Cultural_relic;
import com.zsc.museum.domain.Return;
import com.zsc.museum.mapper.BorrowMapper;
import com.zsc.museum.mapper.CulturalMapper;
import com.zsc.museum.mapper.ReturnMapper;
import com.zsc.museum.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class borrowController {
    @Resource
    BorrowMapper borrowMapper;

    @Resource
    CulturalMapper culturalMapper;

    @Resource
    ReturnMapper returnMapper;

    @Autowired
    public StaffService staffService;

    @GetMapping("/borrowDetails")
    public String borrowDetails(Model model, HttpSession httpSession){
        List<Borrow> details=borrowMapper.findAll();
        model.addAttribute("details", details);

        String a = staffService.selectstatus(1);
        httpSession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/BorrowInfo";
        }

    }

    //单页显示
    @GetMapping("/toBorrow/{id}")
    public String listCultural(@PathVariable Long id,Model model, HttpSession httpSession) {
        List<Borrow> borrows=borrowMapper.findAll();
        Cultural_relic cultural_relic = culturalMapper.SelectOne(id);
        model.addAttribute("cultural_relic", cultural_relic);
        model.addAttribute("borrows", borrows);

        String a = staffService.selectstatus(1);
        httpSession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/CulturalRelicsExits";
        }


    }

    @PostMapping("/createBorrow")
    public String createBorrow(Borrow borrow, Cultural_relic relic){
        Date time = new Date();
        DateFormat borrowFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String borrowTime = borrowFormat.format(time);
        borrow.setBorrowTime(borrowTime);
        Long re = relic.getId();
        borrow.setCulturalRelicId(re);
        borrowMapper.Insert(borrow);
        return "redirect:/findFirstPage?result=1";
    }

    @GetMapping("/borrowDeleteInPage/{borrowId}")
    public String borrowDeleteInPage(@PathVariable Long borrowId) {
        Return return1 = new Return();
        Borrow borrow = borrowMapper.selectOne(borrowId);
        Long id = borrow.getCulturalRelicId();
        String forWho = borrow.getToWho();
        String borrowTime = borrow.getBorrowTime();

        Date time = new Date();
        DateFormat returnFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String returnTime = returnFormat.format(time);
        return1.setReturnTime(returnTime);

        return1.setCulturalRelicId(id);
        return1.setForWho(forWho);
        return1.setBorrowTime(borrowTime);
        returnMapper.Insert(return1);
        borrowMapper.borrowDelete(borrowId);
        return "redirect:/borrowDetails?result=1";
    }

    //通过文物ID模糊查找
    @GetMapping("/selectByCulturalRelicId")
    public String SelectByBorrowId(Model model, HttpServletRequest request,HttpSession httpSession) {
        String culturalRelicId = request.getParameter("culturalRelicId");
        List<Borrow> details = borrowMapper.SelectByCulturalRelicId(culturalRelicId);
        model.addAttribute("details", details);

        String a = staffService.selectstatus(1);
        httpSession.setAttribute("a", a);

        if(a==null){
            return "redirect:/tologin?ban";
        }
        else{
            return "pages/BorrowInfo";
        }

    }
}
