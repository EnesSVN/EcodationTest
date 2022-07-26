package com.example.ecodationtest.controller;


import com.example.ecodationtest.dto.UserDto;
import com.example.ecodationtest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController

public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping("/users/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto) {
       service.createUser(userDto);
        return ResponseEntity.ok().body("User created successfully" + userDto);
    }


    @GetMapping("/users/all")
    public List<UserDto> getAllUsers() {
        List<UserDto> listem = service.getAllUsers();
        return listem;
    }



}
