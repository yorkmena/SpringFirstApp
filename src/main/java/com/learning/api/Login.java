package com.learning.api;

import com.learning.model.LoginCredentials;
import com.learning.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restLogin")
@CrossOrigin
public class Login {

    @Autowired
    LoginService loginService;


    @PostMapping("/processRegistration")
    public String processRegistration(@RequestBody LoginCredentials theUser) {
        System.out.println("restRegister:|" + theUser.getUserName() + "|" + theUser.getPassword());

        if (loginService.registerUser(theUser))
            return "loginPage";
        else
            return "register";
    }

    @PostMapping("/processLogin")
    public String processLogin(@RequestBody LoginCredentials theUser) {
        System.out.println("restLogin:|" + theUser.getUserName() + "|" + theUser.getPassword());

        if (loginService.authenticate(theUser))
            return "login-confirmation";
        else
            return "login-fail";
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<LoginCredentials>> getAllUsers() {
        return new ResponseEntity<>(loginService.getAllUsers(), HttpStatus.OK) ;
    }
}
