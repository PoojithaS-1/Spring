package com.xworkz.formapp.controller;

import com.xworkz.formapp.dto.VisaApplyDto;
import com.xworkz.formapp.service.VisaApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class VisaApplyController {
    @Autowired
    VisaApplyService visaApplyService;

     public VisaApplyController(){
         System.out.println("VisaApplyController cons invoked");
     }
@RequestMapping(value = "addApplicant")
     public String addApplicant(VisaApplyDto visaApplyDto, Model model){
         visaApplyService.validateAndSave(visaApplyDto);
         model.addAttribute("applicantName",visaApplyDto.getApplicantName());
         model.addAttribute("mobileNumber",visaApplyDto.getMobileNumber());
         model.addAttribute("pinCode",visaApplyDto.getPinCode());
         return "response.jsp";
     }
     @RequestMapping("getAllApplicantInfo")
    public String getAllApplicantInfo(Model model){
         List<VisaApplyDto> visaApplyDtos=visaApplyService.getAllApplicantInfo();
         model.addAttribute("ListOfApplicants",visaApplyDtos);
         return "getAllApplicantInfo.jsp";
     }
    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id") String id, HttpServletRequest request){
        visaApplyService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllApplicantInfo");
        return redirectView;
    }
}
