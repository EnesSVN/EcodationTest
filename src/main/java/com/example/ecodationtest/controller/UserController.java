package com.example.ecodationtest.controller;


import com.example.ecodationtest.dto.UserDto;
import com.example.ecodationtest.exception.ApiResult;
import com.example.ecodationtest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult apiResult(MethodArgumentNotValidException exception) {
        ApiResult apiResult = new ApiResult(400, "/users/create", "null variable");
        Map<String, String> validationData = new HashMap<>();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            validationData.put(error.getField(), error.getDefaultMessage());
        }
        apiResult.setValidationData(validationData);
        return apiResult;
    }

}
