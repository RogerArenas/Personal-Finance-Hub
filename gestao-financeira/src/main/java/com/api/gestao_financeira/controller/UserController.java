package com.api.gestao_financeira.controller;

import com.api.gestao_financeira.model.User;
import com.api.gestao_financeira.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.salvarUser(user);
    }

    @GetMapping
    public List<User> listUser(){
        return userService.listarUser();
    }


}
