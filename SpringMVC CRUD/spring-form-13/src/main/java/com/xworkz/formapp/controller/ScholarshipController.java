package com.xworkz.formapp.controller;

import com.xworkz.formapp.dto.ScholarshipDto;
import com.xworkz.formapp.service.ScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ScholarshipController {
    @Autowired
    ScholarshipService scholarshipService;
    public ScholarshipController(){
        System.out.println("ScholarshipController invoked");
    }
    @RequestMapping("addApplicant")
    public String addApplicant(ScholarshipDto scholarshipDto, Model model){
        scholarshipService.validateAndSave(scholarshipDto);
        model.addAttribute("fullName",scholarshipDto.getFullName());
        model.addAttribute("mobileNumber",scholarshipDto.getMobileNumber());
        model.addAttribute("pinCode",scholarshipDto.getPinCode());
        model.addAttribute("annualFamilyIncome",scholarshipDto.getAnnualFamilyIncome());
        return "response.jsp";

    }
    @RequestMapping("getAllApplicantInfo")
    public String getAllApplicantInfo(Model model){
        List<ScholarshipDto>scholarshipDtos=scholarshipService.getAllApplicantInfo();
        model.addAttribute("ListOfApplicants",scholarshipDtos);
        return "getAllApplicantInfo.jsp";

    }
    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id") String id, HttpServletRequest request){
        scholarshipService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllApplicantInfo");
        return redirectView;
    }
}
