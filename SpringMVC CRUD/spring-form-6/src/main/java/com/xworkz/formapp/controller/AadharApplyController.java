package com.xworkz.formapp.controller;

import com.xworkz.formapp.dto.AadharApplyDto;
import com.xworkz.formapp.service.AadharApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AadharApplyController {
    @Autowired
    AadharApplyService aadharApplyService;
    public AadharApplyController(){
        System.out.println("AadharApplyController cons invoked");
    }

    @RequestMapping(value = "addApplicant")
    public String addApplicant(AadharApplyDto aadharApplyDto, Model model){
        aadharApplyService.validateAndSave(aadharApplyDto);
        model.addAttribute("fullName",aadharApplyDto.getFullName());
        model.addAttribute("mobileNumber",aadharApplyDto.getMobileNumber());
        model.addAttribute("pinCode",aadharApplyDto.getPinCode());
        return "response.jsp";

    }
    @RequestMapping(value = "getAllApplicantInfo")
    public String getAllApplicantInfo(Model model){
        List<AadharApplyDto> aadharApplyDtos=aadharApplyService.getAllApplicantInfo();
        model.addAttribute("ListOfApplicants",aadharApplyDtos);
        return "getAllApplicantInfo.jsp";
    }
    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id") String id, HttpServletRequest request){
        aadharApplyService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllApplicantInfo");
        return redirectView;
    }
}
