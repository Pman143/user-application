package com.example.userapplication.service;

import com.example.userapplication.dto.UserDto;
import com.example.userapplication.entity.User;

public interface UserService {

    UserDto findUserById(String id);

    String addUser(UserDto user);

    void deleteUser(String id);

    UserDto updateUser(UserDto user);
}
