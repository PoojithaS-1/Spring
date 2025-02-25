package com.xworkz.form3.controller;

import com.xworkz.form3.dto.StudRegDto;
import com.xworkz.form3.service.StudRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudController {
    @Autowired
    StudRegService studRegService;

    public StudController(){
        System.out.println("StudController cons is invoked");
    }
@RequestMapping(value = "addStud")
    public String addStud(StudRegDto studRegDto, Model model){
       studRegService.validateAndSave(studRegDto);
       model.addAttribute("fullName",studRegDto.getFullName());
       model.addAttribute("mobileNumber",studRegDto.getMobileNumber());
       return "response.jsp";

    }
    @RequestMapping(value = "getAllStudInfo")
    public String getAllStudInfo(Model model){
        List<StudRegDto> studRegDtoList=studRegService.getAllStudInfo();
        model.addAttribute("ListOfStudInfo",studRegDtoList);
        return "getAllStudInfo.jsp";

    }
    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id")String id, HttpServletRequest request){
        studRegService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllStudInfo");
        return redirectView;
    }
}
