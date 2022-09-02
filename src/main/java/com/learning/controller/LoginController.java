package com.learning.controller;

import com.learning.model.LoginCredentials;
import com.learning.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/register")
    public String showRegistrationPage(Model theModel) {
        theModel.addAttribute("user", new LoginCredentials());
        return "registerPage";
    }

    @RequestMapping("/processRegistration")
    public String processRegistration(@ModelAttribute("user") LoginCredentials theUser) {
        System.out.println("Register:|" + theUser.getUserName() + "|" + theUser.getPassword());

        if (loginService.registerUser(theUser))
            return "loginPage";
        else
            return "register";
    }

    @RequestMapping("/login")
    public String showLoginPage(Model theModel) {
        theModel.addAttribute("user", new LoginCredentials());
        return "loginPage";
    }

    @RequestMapping("/processLogin")
    public String processLogin(@ModelAttribute("user") LoginCredentials theUser) {
        System.out.println("Login:|" + theUser.getUserName() + "|" + theUser.getPassword());

        if (loginService.authenticate(theUser))
            return "login-confirmation";
        else
            return "login-fail";
    }
}
