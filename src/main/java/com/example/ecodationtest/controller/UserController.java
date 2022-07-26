package com.example.ecodationtest.controller;


import com.example.ecodationtest.dto.UserDto;
import com.example.ecodationtest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController

public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto) {
       service.createUser(userDto);
        return ResponseEntity.ok().body("User created successfully" + userDto);
    }






}
