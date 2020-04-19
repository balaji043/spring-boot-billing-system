package com.bam.bs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.bam.bs.dto.UserDto;
import com.bam.bs.dto.UserRequest;
import com.bam.bs.model.*;
import com.bam.bs.repository.UserRepository;
import com.bam.bs.service.UserService;
import com.bam.bs.util.Message;
import com.bam.bs.util.Messages;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDto saveUser(UserDto userDto) {
        return mapUser(userRepository.save(mapUser(userDto)));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return mapUser(userRepository.save(mapUser(userDto)));
    }

    @Override
    public List<UserDto> searchUsers(UserRequest readValue) {
        return userRepository.findAll().stream().map(this::mapUser).collect(Collectors.toList());
    }

    @Override
    public Message deleteUser(Long[] ids) {
        userRepository.deleteAllById(ids);
        return new Message(Messages.SUCCESS);
    }

    private User mapUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private UserDto mapUser(User user) {
        return modelMapper.map(user, UserDto.class);
    }
    
}