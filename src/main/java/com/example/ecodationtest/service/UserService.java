package com.example.ecodationtest.service;

import com.example.ecodationtest.dto.UserDto;
import com.example.ecodationtest.entity.UserEntity;
import com.example.ecodationtest.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {


    public UserRepository userRepository;

    public ModelMapper modelMapper;

    public PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }



    public UserDto EntityToDto(UserEntity userEntity) {
        return modelMapper.map(userEntity,UserDto.class);
    }

    public UserEntity DtoToEntity(UserDto userDto) {
        return modelMapper.map(userDto,UserEntity.class);
    }

    //Create

    public UserDto createUser(UserDto userDto) {
        String encrytedMasked=passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encrytedMasked);
        UserEntity entity=DtoToEntity(userDto);
        userRepository.save(entity);
        return userDto;
    }

    public List<UserDto> getAllUsers(){
        List<UserDto> list = new ArrayList<>();
        Iterable<UserEntity> listem = userRepository.findAll();
        for (UserEntity userEntity : listem) {
            list.add(EntityToDto(userEntity));
        }
        return list;
    }


}
