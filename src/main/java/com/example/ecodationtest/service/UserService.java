package com.example.ecodationtest.service;

import com.example.ecodationtest.entity.UserEntity;
import com.example.ecodationtest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    public UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //save user
    public UserEntity saveUser(UserEntity userEntity) {
       return userRepository.save(userEntity);
    }

    //List all users
    public List<UserEntity> listAllUsers() {

        return userRepository.findAll();
    }


}
