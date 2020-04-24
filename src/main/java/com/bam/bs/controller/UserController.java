package com.bam.bs.controller;

import java.util.List;

import com.bam.bs.dto.ApiResponse;
import com.bam.bs.dto.UserDto;
import com.bam.bs.dto.UserRequest;
import com.bam.bs.service.UserService;
import com.bam.bs.util.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController()
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@ApiOperation(value = "Save User")
	public ApiResponse<UserDto> saveUser(@RequestBody UserDto userDto) {
		return new ApiResponse<>(userService.saveUser(userDto), "okay", "User successfully saved");
	}

	@PutMapping
	@ApiOperation(value = "Update User")
	public UserDto updateUser(@RequestBody UserDto userDto) {
		return userService.updateUser(userDto);
	}

	@PostMapping("/search")
	@ApiOperation(value = "Search Users")
	public List<UserDto> searchUsers(UserRequest userRequest) {
		return userService.searchUsers(userRequest);
	}

	@DeleteMapping
	@ApiOperation(value = "Delete User")
	public Message deleteUser(@RequestParam("ids[]") Long[] ids) {
		return userService.deleteUser(ids);
	}

}
