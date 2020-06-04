package com.zsc.museum.controller;

import com.zsc.museum.domain.In_library;
import com.zsc.museum.domain.Staff;
import com.zsc.museum.mapper.InMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class InController {
    @Resource
    InMapper inMapper;

    //文物入馆


    //查看
    @GetMapping("/in_library")
    public String listIn(Model model) {
        List<In_library> in_libraryList=inMapper.findAll();
        List<In_library> in_librarie  = inMapper.FindtoPage(0);
        model.addAttribute("In_library", in_librarie);
        model.addAttribute("num", in_librarie.size());
        return "pages/in_library";
    }
    @GetMapping("/findtoinPage")
    public String FindtoPage(Model model,Integer i) {
        List<In_library> in_librarie = inMapper.FindtoPage(i);
        List<In_library> in_libraryList=inMapper.findAll();
        model.addAttribute("In_library", in_librarie);
        model.addAttribute("num", in_libraryList.size());
        return "pages/in_library";
    }
    //增加

    @GetMapping("/AddIn_library")
    public String InAdd() {
        return "pages/AddIn_library";
    }

    @PostMapping("/AddIn_library")
    public String createIn(In_library in_library) {
        inMapper.Insert(in_library);
        return "redirect:/in_library";
    }

    //删除

    @GetMapping("/deletein/{id}")
    public String delete(@PathVariable Long id) {
        inMapper.delete(id);
        //重定向到list URL
        return "redirect:/in_library?result=1";
    }


    //编辑

    @GetMapping("/in_libraryEdit/{id}")
    public String toinEdit(@PathVariable Long id, Model model) {
        In_library in_library = inMapper.SelectOne(id);
        model.addAttribute("In_library", in_library);
        return "pages/in_libraryEdit";
    }
    @PostMapping("/updatein_library")
    public String in_libraryEdit(In_library in_library) {
        inMapper.update(in_library);
        return "redirect:/in_library";
    }

}
