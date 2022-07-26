package com.example.ecodationtest.service;

import com.example.ecodationtest.dto.UserDto;
import com.example.ecodationtest.entity.UserEntity;

public interface IUserService {


    public UserEntity DtoToEntity(UserDto userDto);

    public UserDto createUser(UserDto userDto);

}
