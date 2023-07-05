package com.example.doan3.controller;

import com.example.doan3.service.StaffService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    public static boolean login = false;

    @Autowired
    private StaffService staffService;

    @GetMapping("/login")
    String login(Model model) {

        model.addAttribute("incorrect", false);

        return "login";
    }

    @PostMapping("/check-login")
    String validateLogin(HttpServletRequest request, Model model, HttpSession session){
        boolean b = staffService.checkLogin(request.getParameter("email"),request.getParameter("password"));
        if (!b){
            model.addAttribute("incorrect",true);
            return "login";
        }
        login=true;
        return "redirect:/home-page-customer";
    }

    @GetMapping("/logout")
    String logout(){
        login=false;
        return "redirect:/home-page-customer";
    }
}
