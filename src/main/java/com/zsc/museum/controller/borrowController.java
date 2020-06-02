package com.zsc.museum.controller;

import com.zsc.museum.domain.Borrow;
import com.zsc.museum.domain.Cultural_relic;
import com.zsc.museum.mapper.BorrowMapper;
import com.zsc.museum.mapper.CulturalMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
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

    @GetMapping("/borrowDetails")
    public String borrowDetails(Model model){
        List<Borrow> details=borrowMapper.findAll();
        model.addAttribute("details", details);
        return "pages/BorrowInfo";
    }

    //单页显示
    @GetMapping("/toBorrow/{id}")
    public String listCultural(@PathVariable Long id,Model model) {
        List<Borrow> borrows=borrowMapper.findAll();
        Cultural_relic cultural_relic = culturalMapper.SelectOne(id);
        model.addAttribute("cultural_relic", cultural_relic);
        model.addAttribute("borrows", borrows);
        return "pages/CulturalRelicsExits";
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

    @GetMapping("/borrowDelete/{culturalRelicId}")
    public String borrowDelete(@PathVariable Long culturalRelicId) {
        borrowMapper.borrowDelete(culturalRelicId);
        return "redirect:/toBorrow/{culturalRelicId}?result=1";
    }
}
