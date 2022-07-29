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


    //JPA Repository Create
    @PostMapping("/users/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto) {
       service.createUser(userDto);
        return ResponseEntity.ok().body("User created successfully" + userDto);
    }


    //JPA Repository GetAll
    @GetMapping("/users/all")
    public List<UserDto> getAllUsers() {
        List<UserDto> listem = service.getAllUsers();
        return listem;
    }

    //JPA Repository GetById
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
        ResponseEntity<UserDto> response = service.getUserById(id);
        return response;
    }

    //JPA Repository Update
    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        ResponseEntity<UserDto> response = service.updateUser(id, userDto);
        return response.ok(userDto);
    }

    //JPA Repository Delete
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") Long id) {
        service.deleteUser(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



    //NAMED QUERY Create
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
