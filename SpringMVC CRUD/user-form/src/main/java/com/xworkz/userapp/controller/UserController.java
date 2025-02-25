package com.xworkz.userapp.controller;

import com.xworkz.userapp.dto.UserDto;
import com.xworkz.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(){
        System.out.println("UserController object is created");
    }

    @RequestMapping(value = "addUser")
    public String addUser(UserDto userDto, Model model){
        userService.validateAndSaveUser(userDto);
        model.addAttribute("firstName",userDto.getFirstName());
        model.addAttribute("phoneNumber", userDto.getPhoneNumber());
        return "response.jsp";
    }

    @RequestMapping(value = "getAllUserInfo")
    public String getAllUserInfo(Model model) {
        List<UserDto> userList = userService.getAllUserInfo();
        model.addAttribute("ListOfUsers", userList);
        return "getAllUserInfo.jsp";
    }
    @RequestMapping(value = "delete")
    public RedirectView deleteById(@RequestParam("id")String id, HttpServletRequest request){
        userService.deleteById(Integer.parseInt(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/getAllUserInfo");
        return redirectView;
    }

}
