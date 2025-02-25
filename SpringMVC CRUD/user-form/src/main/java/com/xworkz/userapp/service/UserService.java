package com.xworkz.userapp.service;

import com.xworkz.userapp.dto.UserDto;

import java.util.List;


public interface UserService {
    Boolean validateAndSaveUser(UserDto userDto);

    List<UserDto> getAllUserInfo();

    void deleteById(Integer id);
}
