package com.hutech.bai_1.Controllers;

import com.hutech.bai_1.Entities.User;
import com.hutech.bai_1.RequestEntities.UserCreate;
import com.hutech.bai_1.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class UserRestController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @PostMapping("")
    public User createStudent(@RequestBody UserCreate userCreate){
        return userService.createUser(userCreate);
    }
}
