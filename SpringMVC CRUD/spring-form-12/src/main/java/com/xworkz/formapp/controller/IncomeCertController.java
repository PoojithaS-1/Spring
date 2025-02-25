package com.xworkz.formapp.controller;

import com.xworkz.formapp.dto.IncomeCertDto;
import com.xworkz.formapp.service.IncomeCertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IncomeCertController {
    @Autowired
    IncomeCertService incomeCertService;
    public IncomeCertController(){
        System.out.println("IncomeCertController invoked");
    }
    @RequestMapping("addApplicant")
    public String addApplicant(IncomeCertDto incomeCertDto, Model model){
        incomeCertService.validateAndSave(incomeCertDto);
        model.addAttribute("fullName",incomeCertDto.getFullName());
        model.addAttribute("mobileNumber",incomeCertDto.getMobileNumber());
        model.addAttribute("pinCode",incomeCertDto.getPinCode());
        model.addAttribute("annualIncome",incomeCertDto.getAnnualIncome());
        return "response.jsp";
    }
    @RequestMapping(value = "getAllApplicantInfo")
    public String getAllApplicantInfo(Model model){
        List<IncomeCertDto> incomeCertDtos=incomeCertService.getAllApplicantInfo();
        model.addAttribute("ListOfApplicants",incomeCertDtos);
        return "getAllApplicantInfo.jsp";
    }
    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id") String id, HttpServletRequest request){
        incomeCertService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllApplicantInfo");
        return redirectView;
    }
}
