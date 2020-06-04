package com.zsc.museum.controller;

import com.zsc.museum.domain.In_library;
import com.zsc.museum.domain.Out_library;
import com.zsc.museum.mapper.OutMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OutController {
    @Resource
    OutMapper outMapper;
    //文物出馆

    //查看
    @GetMapping("/out_library")
    public String listout(Model model) {
        List<Out_library> out_libraryList=outMapper.findAll();
        List<Out_library> out_libraries  = outMapper.FindtoPage(0);
        model.addAttribute("Out_library", out_libraries);
        model.addAttribute("num", out_libraries.size());
        return "pages/out_library";
    }
    @GetMapping("/findtooutPage")
    public String FindtoPage(Model model,Integer i) {
        List<Out_library> out_libraries = outMapper.FindtoPage(i);
        List<Out_library> out_libraryList=outMapper.findAll();
        model.addAttribute("Out_library", out_libraries);
        model.addAttribute("num", out_libraryList.size());
        return "pages/out_library";
    }
    //增加

    @GetMapping("/AddOut_library")
    public String InAdd() {
        return "pages/AddOut_library";
    }

    @PostMapping("/AddOut_library")
    public String createOut(Out_library out_library) {
        outMapper.Insert(out_library);
        return "redirect:/out_library";
    }

    //删除

    @GetMapping("/deleteout/{id}")
    public String delete(@PathVariable Long id) {
        outMapper.delete(id);
        //重定向到list URL
        return "redirect:/out_library?result=1";
    }


    //编辑

    @GetMapping("/out_libraryEdit/{id}")
    public String tooutEdit(@PathVariable Long id, Model model) {
        Out_library out_library = outMapper.SelectOne(id);
        model.addAttribute("Out_library", out_library);
        return "pages/out_libraryEdit";
    }
    @PostMapping("/updateout_library")
    public String out_libraryEdit(Out_library out_library) {
        outMapper.update(out_library);
        return "redirect:/out_library";
    }


}
