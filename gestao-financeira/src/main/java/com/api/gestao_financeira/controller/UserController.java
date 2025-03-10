package com.api.gestao_financeira.controller;

import com.api.gestao_financeira.model.User;
import com.api.gestao_financeira.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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


    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable (value = "id")UUID id){
        Optional<User> user0 = userService.findById(id);
        if(user0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found in database");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user0.get());
    }
}
