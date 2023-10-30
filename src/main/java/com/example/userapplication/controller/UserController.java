package com.example.userapplication.controller;

import com.example.userapplication.dto.UserDto;
import com.example.userapplication.entity.User;
import com.example.userapplication.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable String id) {
        return userService.findUserById(id);
    }

    @PostMapping()
    public String saveUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @PutMapping()
    public UserDto updateUser(@RequestBody UserDto user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
