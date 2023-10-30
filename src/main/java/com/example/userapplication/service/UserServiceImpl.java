package com.example.userapplication.service;

import com.example.userapplication.dto.UserDto;
import com.example.userapplication.entity.User;
import com.example.userapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto findUserById(String id) {
        User user = userRepository.findById(id).orElse(new User());
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmailAddress(user.getEmailAddress());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }

    @Override
    public String addUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmailAddress(userDto.getEmailAddress());
        return userRepository.save(user).getId();
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        UserDto existingUser = findUserById(userDto.getId());
        if (existingUser == null) {
            return userDto;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmailAddress(userDto.getEmailAddress());
        userRepository.save(user);
        return userDto;
    }
}
