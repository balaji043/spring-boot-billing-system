package com.bam.bs.service;

import java.util.List;

import com.bam.bs.dto.UserRequest;
import com.bam.bs.dto.UserDto;
import com.bam.bs.entity.User;
import com.bam.bs.util.Message;

public interface UserService {

	User saveUser(UserDto userDto);

	User updateUser(UserDto userDto);

	List<UserDto> searchUsers(UserRequest readValue);

	Message deleteUser(Long[] ids);
}
