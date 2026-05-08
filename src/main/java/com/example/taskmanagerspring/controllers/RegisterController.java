package com.example.taskmanagerspring.controllers;

import com.example.taskmanagerspring.repository.UserRepository;
import com.example.taskmanagerspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showRegisterForm(){
        return "register";
    }


    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public String registerUser(@RequestParam String username,@RequestParam String password) {
        try {
            userService.register(username, password);
            return "redirect:/login";
        }catch (Exception e){
            return "redirect:/register?error";
        }
    }
}
