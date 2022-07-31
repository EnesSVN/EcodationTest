package com.example.ecodationtest.service;

import com.example.ecodationtest.dto.UserDto;
import com.example.ecodationtest.entity.UserEntity;
import com.example.ecodationtest.exception.ResourceNotFoundException;
import com.example.ecodationtest.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return modelMapper.map(userEntity, UserDto.class);
    }

    public UserEntity DtoToEntity(UserDto userDto) {
        return modelMapper.map(userDto, UserEntity.class);
    }

    //JpaRepository Create
    public UserDto createUser(UserDto userDto) {
        String encrytedMasked = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encrytedMasked);
        UserEntity entity = DtoToEntity(userDto);
        userRepository.save(entity);
        return userDto;
    }

    //JpaRepository GetAll
    public List<UserDto> getAllUsers() {
        List<UserDto> list = new ArrayList<>();
        Iterable<UserEntity> listem = userRepository.findAll();
        for (UserEntity userEntity : listem) {
            list.add(EntityToDto(userEntity));
        }
        return list;
    }

    //JpaRepository GetById
    public ResponseEntity<UserDto> getUserById(Long id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
        UserDto userDto = EntityToDto(entity);
        return ResponseEntity.ok(userDto);
    }

    //JpaRepository Update
    public ResponseEntity<UserDto> updateUser(Long id, UserDto userDto) {
        UserEntity entity = DtoToEntity(userDto);
        UserEntity userFind = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));

        userFind.setName(entity.getName());
        userFind.setSurname(entity.getSurname());
        userFind.setEmail(entity.getEmail());
        userFind.setPassword(entity.getPassword());

        UserEntity updatedEntity = userRepository.save(userFind);
        UserDto updatedDto = EntityToDto(updatedEntity);
        return ResponseEntity.ok(updatedDto);
    }

    //JpaRepository Delete
    public ResponseEntity<Map<String, Boolean>> deleteUser(Long id) {
        UserEntity userFind = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
        userRepository.delete(userFind);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


    //NamedQuery GetAll
    public List<UserDto> findAllUser() {
        List<UserDto> list = new ArrayList<>();
        Iterable<UserEntity> listem = userRepository.findAllUser();
        for (UserEntity userEntity : listem) {
            list.add(EntityToDto(userEntity));
        }
        return list;
    }

    public ResponseEntity<UserDto> getUserByIdUser(Long id) {
        UserEntity entity = userRepository.findUserByIdUser(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
        UserDto userDto = EntityToDto(entity);
        return ResponseEntity.ok(userDto);


    }
}
