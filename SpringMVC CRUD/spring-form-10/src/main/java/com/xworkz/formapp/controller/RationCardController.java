package com.xworkz.formapp.controller;

import com.xworkz.formapp.dto.RationCardDto;
import com.xworkz.formapp.service.RationCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RationCardController {
    @Autowired
    RationCardService rationCardService;
    public RationCardController(){
        System.out.println("RationCardController cons invoked");
    }
    @RequestMapping(value = "addApplicant")
    public String addApplicant(RationCardDto rationCardDto, Model model){
        rationCardService.validateAndSave(rationCardDto);
        model.addAttribute("fullName",rationCardDto.getFullName());
        model.addAttribute("mobileNumber",rationCardDto.getMobileNumber());
        model.addAttribute("pinCode",rationCardDto.getPinCode());
        return "response.jsp";
    }
    @RequestMapping(value = "getAllApplicantInfo")
    public String getAllApplicantInfo(Model model){
        List<RationCardDto> rationCardDtos=rationCardService.getAllApplicantInfo();
        model.addAttribute("ListOfApplicants",rationCardDtos);
        return "getAllApplicantInfo.jsp";

    }
    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id") String id, HttpServletRequest request){
        rationCardService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllApplicantInfo");
        return redirectView;
    }
}
