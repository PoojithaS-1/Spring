package com.xworkz.formapp.controller;

import com.xworkz.formapp.dto.VoterIdApplyDto;
import com.xworkz.formapp.service.VoterIdApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class VoterIdApplyController {
    @Autowired
    private VoterIdApplyService voterIdApplyService;

    public VoterIdApplyController(){
        System.out.println("UserController object is created");
    }

    @RequestMapping(value = "addApplicant")
    public String addApplicant(VoterIdApplyDto voterIdApplyDto, Model model){
        voterIdApplyService.validateAndSave(voterIdApplyDto);
        model.addAttribute("fullName",voterIdApplyDto.getFullName());
        model.addAttribute("mobileNumber", voterIdApplyDto.getMobileNumber());
        model.addAttribute("pinCode", voterIdApplyDto.getPinCode());

        return "response.jsp";
    }

    @RequestMapping(value = "getAllApplicantInfo")
    public String getAllApplicantInfo(Model model) {
        List<VoterIdApplyDto> voterIdApplyDtos = voterIdApplyService.getAllApplicantInfo();
        model.addAttribute("ListOfApplicants", voterIdApplyDtos);
        return "getAllApplicantInfo.jsp";
    }
    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id") String id, HttpServletRequest request){
        voterIdApplyService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllApplicantInfo");
        return redirectView;
    }
}
