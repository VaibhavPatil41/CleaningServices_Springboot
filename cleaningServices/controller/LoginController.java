package com.cleaningServices.controller;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cleaningServices.entities.Login;
import com.cleaningServices.services.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private Loginservice loginService;

    @PostMapping("/register")
    public void register(@RequestBody Login login) {
        loginService.save(login);
    }

    @GetMapping("/authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        Login login = loginService.findByUsername(username);
        

        System.out.println(login);
        if (login != null && password.equals(login.getPassword())) 
        {
//        	System.out.println(login);
//        	System.out.println(login.getRoleid());
            return "Login successful";
        }
        else 
        {
            return "Invalid credentials";
        }
    }
}

