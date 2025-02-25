package com.xworkz.edutechapp.controller;

import com.xworkz.edutechapp.dto.EduTechDto;
import com.xworkz.edutechapp.service.EduTechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EduTechController {
    @Autowired
    EduTechService eduTechService;
    @RequestMapping("addTrainee")
    public String addTrainee(EduTechDto eduTechDto, Model model) {
        eduTechService.validateAndSave(eduTechDto);
        model.addAttribute("name", eduTechDto.getName());
        model.addAttribute("contactNo", eduTechDto.getContactNo());
        model.addAttribute("yearOfStudy", eduTechDto.getYearOfStudy());
        return "response.jsp";
    }
    @RequestMapping("getAllTraineeInfo")
    public String getAllTraineeInfo(Model model){
       List<EduTechDto> eduTechDtos= eduTechService.getAllTraineeInfo();
       model.addAttribute("ListOfTrainee",eduTechDtos);
       return "getAllTraineeInfo.jsp";
    }
    @RequestMapping("delete")
    public RedirectView deleteById(@RequestParam("id")String id, HttpServletRequest request){
        eduTechService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllTraineeInfo");
        return redirectView;
    }

}
