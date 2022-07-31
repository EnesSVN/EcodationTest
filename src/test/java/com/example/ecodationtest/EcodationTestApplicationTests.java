package com.example.ecodationtest;


import com.example.ecodationtest.entity.UserEntity;
import com.example.ecodationtest.repository.UserRepository;
import com.example.ecodationtest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EcodationTestApplicationTests implements ITest {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @Override
    @Test
    public void testCreate() {
        UserEntity userEntity = UserEntity.builder().name("Enes").surname("SEVEN").email("enes@gmail.com").password("123456eSfrtVFDS@").build();
        userRepository.save(userEntity);
        assertNotNull(userRepository.findById(1L).get());
    }

    @Override
    @Test
    public void testCreateFail() {
        // Test failed because of missing password
        UserEntity userEntity = UserEntity.builder().name("Enes").surname("SEVEN").email("enes.seven@gmail.com").build();
        assertThrows(Exception.class, () -> {
            userService.createUser(userService.EntityToDto(userEntity));
        });

    }
}
