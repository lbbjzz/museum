package com.zsc.museum.controller;

import com.zsc.museum.domain.Borrow;
import com.zsc.museum.mapper.BorrowMapper;
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

    //单页显示
    @GetMapping("/toBorrow")
    public String listCultural(Model model) {
        List<Borrow> borrows=borrowMapper.findAll();
        model.addAttribute("borrows", borrows);
        return "pages/CulturalRelicsExits";
    }

    @PostMapping("/createBorrow")
    public String createBorrow(Borrow borrow){
        Date time = new Date();
        DateFormat borrowFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String borrowTime = borrowFormat.format(time);
        borrow.setBorrowTime(borrowTime);
        borrowMapper.Insert(borrow);
        return "redirect:/toBorrow";
    }

    @GetMapping("/borrowDelete/{culturalRelicId}")
    public String borrowDelete(@PathVariable Long culturalRelicId) {
        borrowMapper.borrowDelete(culturalRelicId);
        return "redirect:/toBorrow?result=1";
    }
}
