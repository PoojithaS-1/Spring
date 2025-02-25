package com.xworkz.formapp.controller;

import com.xworkz.formapp.dto.PanApplyDto;
import com.xworkz.formapp.service.PanApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PanApplyController {
    @Autowired
    PanApplyService panApplyService;

    public PanApplyController(){
        System.out.println("PanApplyController cons invoked");
    }
    @RequestMapping(value = "addApplicant")
    public String addApplicant(PanApplyDto panApplyDto, Model model){
        panApplyService.validateAndSave(panApplyDto);
        model.addAttribute("fullName",panApplyDto.getFullName());
        model.addAttribute("mobileNumber",panApplyDto.getMobileNumber());
        model.addAttribute("pinCode",panApplyDto.getPinCode());
        return "response.jsp";
    }
    @RequestMapping(value = "getAllApplicantInfo")
    public String getAllApplicantInfo(Model model){
        List<PanApplyDto> panApplyDtos=panApplyService.getAllApplicantInfo();
        model.addAttribute("ListOfApplicants",panApplyDtos);
        return "getAllApplicantInfo.jsp";
    }
    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id") String id, HttpServletRequest request){
        panApplyService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllApplicantInfo");
        return redirectView;
    }
}
