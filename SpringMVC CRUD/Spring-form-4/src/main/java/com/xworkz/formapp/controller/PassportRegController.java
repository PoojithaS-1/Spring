package com.xworkz.formapp.controller;

import com.xworkz.formapp.dto.PassportRegDto;
import com.xworkz.formapp.service.PassportRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PassportRegController {
    @Autowired
    PassportRegService passportRegService;

    public PassportRegController(){
        System.out.println("PassportRegController cons invoked");
    }

    @RequestMapping(value = "addApplicant")
    public String addApplicant(PassportRegDto passportRegDto, Model model){
        passportRegService.validateAndSave(passportRegDto);
        model.addAttribute("applicantName",passportRegDto.getApplicantName());
        model.addAttribute("mobileNumber",passportRegDto.getMobileNumber());
        model.addAttribute("pinCode",passportRegDto.getPinCode());
        return "response.jsp";
    }
@RequestMapping(value = "getAllApplicantInfo")
    public String getAllApplicantInfo(Model model){
        List<PassportRegDto> passportRegDtos=passportRegService.getAllApplicantInfo();
        model.addAttribute("ListOfApplicants",passportRegDtos);
        return "getAllApplicantInfo.jsp";

    }
    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id")String id, HttpServletRequest request){
        passportRegService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllApplicantInfo");
        return redirectView;
    }
}
