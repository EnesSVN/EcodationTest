package com.example.ecodationtest.service;

import com.example.ecodationtest.dto.UserDto;
import com.example.ecodationtest.entity.UserEntity;

import java.util.List;

public interface IUserService {


    public UserEntity DtoToEntity(UserDto userDto);

    public UserDto createUser(UserDto userDto);

    public List<UserDto> getAllUsers();

    public List<UserDto> findAllUser();

}
