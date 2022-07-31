package com.example.ecodationtest.service;

import com.example.ecodationtest.dto.UserDto;
import com.example.ecodationtest.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IUserService {


    public UserEntity DtoToEntity(UserDto userDto);

    //jpaRepository
    public UserDto createUser(UserDto userDto);

    public List<UserDto> getAllUsers();

    public ResponseEntity <UserDto> getUserById(Long id);

    public ResponseEntity <UserDto> updateUser(Long id, UserDto userDto);

    public ResponseEntity <Map<String, Boolean>> deleteUser(Long id);

    public ResponseEntity <UserDto> getUserByIdUser(Long id);

    public List<UserDto> findUserByNameContainingIgnoreCase(String name);



    public List<UserDto> findAllUser();



}
