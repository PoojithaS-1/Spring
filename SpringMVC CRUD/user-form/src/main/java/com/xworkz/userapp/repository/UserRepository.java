package com.xworkz.userapp.repository;

import com.xworkz.userapp.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    Boolean saveUser(UserEntity userEntity);

    List<UserEntity> getAllUserInfo();

    void deleteById(Integer id);
}
