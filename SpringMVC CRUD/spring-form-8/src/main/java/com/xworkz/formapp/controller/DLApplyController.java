package com.xworkz.formapp.controller;

import com.xworkz.formapp.dto.DLApplyDto;
import com.xworkz.formapp.service.DLApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DLApplyController {
    @Autowired
    DLApplyService dlApplyService;
    public DLApplyController(){
        System.out.println("DLApplyController cons invoked");
    }
    @RequestMapping(value = "addApplicant")
    public String addApplicant(DLApplyDto dlApplyDto, Model model){
        dlApplyService.validateAndSave(dlApplyDto);
        model.addAttribute("fullName",dlApplyDto.getFullName());
        model.addAttribute("mobileNumber",dlApplyDto.getMobileNumber());
        model.addAttribute("pinCode",dlApplyDto.getPinCode());
        return "response.jsp";
    }
    @RequestMapping(value = "getAllApplicantInfo")
    public String getAllApplicantInfo(Model model){
        List<DLApplyDto> dlApplyDtos=dlApplyService.getAllApplicantInfo();
        model.addAttribute("ListOfDrivers",dlApplyDtos);
        return "getAllApplicantInfo.jsp";
    }
    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id") String id, HttpServletRequest request){
        dlApplyService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllApplicantInfo");
        return redirectView;
    }
}
