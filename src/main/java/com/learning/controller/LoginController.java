package com.learning.controller;

import com.learning.model.User;
import com.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.learning.dao.LoginDao;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/register")
    public String showRegistrationPage(Model theModel) {
        theModel.addAttribute("user", new User());
        return "registerPage";
    }

    @RequestMapping("/processRegistration")
    public String processRegistration(@ModelAttribute("user") User theUser) {
        System.out.println("Login:|" + theUser.getUserName() + "|" + theUser.getPassword());

        if (userService.registerUser(theUser))
            return "loginPage";
        else
            return "register";
    }

    @RequestMapping("/login")
    public String showLoginPage(Model theModel) {
        theModel.addAttribute("user", new User());
        return "loginPage";
    }

    @RequestMapping("/processLogin")
    public String processLogin(@ModelAttribute("user") User theUser) {
        System.out.println("Login:|" + theUser.getUserName() + "|" + theUser.getPassword());

        if (userService.authenticate(theUser))
            return "login-confirmation";
        else
            return "login-fail";
    }
}
