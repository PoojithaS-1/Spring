package com.xworkz.formapp.controller;

import com.xworkz.formapp.dto.JobApplyDto;
import com.xworkz.formapp.service.JobApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class JobApplyController {
    @Autowired
    JobApplyService jobApplyService;
    public JobApplyController(){
        System.out.println("JobApplyController invoked");
    }
    @RequestMapping(value = "addApplicant")
    public String addApplicant(JobApplyDto jobApplyDto, Model model){
        jobApplyService.validateAndSave(jobApplyDto);
        model.addAttribute("fullName",jobApplyDto.getFullName());
        model.addAttribute("mobileNumber",jobApplyDto.getMobileNumber());
        model.addAttribute("pinCode",jobApplyDto.getPinCode());
        return "response.jsp";
    }
    @RequestMapping(value = "getAllApplicantInfo")
    public String getAllApplicantInfo(Model model){
        List<JobApplyDto> jobApplyDtos=jobApplyService.getAllApplicantInfo();
        model.addAttribute("ListOfApplicants",jobApplyDtos);
        return "getAllApplicantInfo.jsp";
    }
    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id")String id, HttpServletRequest request){
        jobApplyService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllApplicantInfo");
        return redirectView;
    }
}
