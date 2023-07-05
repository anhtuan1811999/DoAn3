package com.example.doan3.controller;

import com.example.doan3.service.StaffService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/login")
    String login(Model model) {

        model.addAttribute("incorrect", false);

        return "login";
    }

    @PostMapping("/check-login")
    String validateLogin(HttpServletRequest request, Model model){
        boolean b = staffService.checkLogin(request.getParameter("email"),request.getParameter("password"));
        if (!b){
            model.addAttribute("incorrect",true);
            return "/login";
        }
        return "redirect:/home-page-customer";
    }
}
