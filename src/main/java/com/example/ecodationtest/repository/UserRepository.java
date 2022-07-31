package com.example.ecodationtest.repository;

import com.example.ecodationtest.dto.UserDto;
import com.example.ecodationtest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllUser();

    Optional<UserEntity> findUserByIdUser(Long id);




}
