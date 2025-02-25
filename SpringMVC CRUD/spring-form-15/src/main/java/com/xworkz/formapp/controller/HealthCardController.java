package com.xworkz.formapp.controller;

import com.xworkz.formapp.dto.HealthCardDto;
import com.xworkz.formapp.service.HealthCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HealthCardController {
    @Autowired
    HealthCardService healthCardService;
    public HealthCardController(){
        System.out.println("HealthCardController invoked");
    }
    @RequestMapping(value = "addApplicant")
    public String addApplicant(HealthCardDto healthCardDto, Model model){
        healthCardService.validateAndSave(healthCardDto);
        model.addAttribute("fullName",healthCardDto.getFullName());
//        model.addAttribute("mobileNumber",healthCardDto.getMobileNumber());
//        model.addAttribute("pinCode",healthCardDto.getPinCode());
        return "response.jsp";
    }
    @RequestMapping(value = "getAllApplicantInfo")
    public String getAllApplicantInfo(Model model){
        List<HealthCardDto>healthCardDtos=healthCardService.getAllApplicantInfo();
        model.addAttribute("ListOfApplicants",healthCardDtos);
        return "getAllApplicantInfo.jsp";

    }

    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id") String id, HttpServletRequest request){
        healthCardService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllApplicantInfo");
        return redirectView;
    }
}
