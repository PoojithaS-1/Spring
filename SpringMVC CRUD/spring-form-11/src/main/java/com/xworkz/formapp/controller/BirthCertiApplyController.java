package com.xworkz.formapp.controller;

import com.xworkz.formapp.dto.BirthCertificateDto;
import com.xworkz.formapp.service.BirthCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BirthCertiApplyController {
    @Autowired
    BirthCertificateService birthCertificateService;
    public BirthCertiApplyController(){
        System.out.println("BirthCertiApplyController cons invoked");

    }
    @RequestMapping(value = "addApplicant")
    public String addApplicant(BirthCertificateDto birthCertificateDto, Model model){
        birthCertificateService.validateAndSave(birthCertificateDto);
        model.addAttribute("childName",birthCertificateDto.getChildName());
        model.addAttribute("pinCode",birthCertificateDto.getPinCode());
        return "response.jsp";
    }
    @RequestMapping(value = "getAllApplicantInfo")
    public String getAllApplicantInfo(Model model){
        List<BirthCertificateDto> birthCertificateDtos =birthCertificateService.getAllApplicantInfo();
        model.addAttribute("ListOfApplicants",birthCertificateDtos);
        return "getAllApplicantInfo.jsp";
    }
    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id") String id, HttpServletRequest request){
        birthCertificateService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllApplicantInfo");
        return redirectView;
    }
}
