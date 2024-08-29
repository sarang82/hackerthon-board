package com.board.board.controller;

import com.board.board.entity.User;
import com.board.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inhatc/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestParam("stu_id") String stu_id,
                               @RequestParam("name") String name,
                               @RequestParam("gender") String gender) {
        try {
            User user = new User();
            user.setStu_id(stu_id);;
            user.setName(name);
            user.setGender(gender);
            userService.register(user);
            return "User registered successfully";
        } catch (Exception e) {
            e.printStackTrace(); // 로그에 예외 출력
            return "Error: " + e.getMessage(); // 오류 메시지를 반환
        }
    }

}
