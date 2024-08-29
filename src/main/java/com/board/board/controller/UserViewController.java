package com.board.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

    @GetMapping("/user/register")
    public String showRegisterForm() {
        return "register";  // templates 폴더의 register.html을 반환
    }
}
