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


    private IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }


    //JPA KULLANIMI
    @PostMapping("/users/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto) {
       service.createUser(userDto);
        return ResponseEntity.ok().body("User created successfully" + userDto);
    }


    //JPA KULLANIMI
    @GetMapping("/users/all")
    public List<UserDto> getAllUsers() {
        List<UserDto> listem = service.getAllUsers();
        return listem;
    }

    //NAMED QUERY KULLANIMI
    @GetMapping("/users/findAll")
    public List<UserDto> findAllUser() {
        List<UserDto> listem = service.findAllUser();
        return listem;
    }

}
