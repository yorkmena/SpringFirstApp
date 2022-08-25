package com.learning;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/showForm")
    public String showPage(Model themodle) {
        User user = new User();
        themodle.addAttribute("user", user);
        return "loginPage";
    }

    @RequestMapping("/processForm")
    public String ProcessForm(@ModelAttribute("user") User theUser) {
        System.out.println("theUser:|"+ theUser.getUsernameName() +"|" + theUser.getPassword());

        //System.out.println(theBindingResult);

        return "login-confirmation";
    }
}
