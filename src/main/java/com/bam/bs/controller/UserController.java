package com.bam.bs.controller;

import java.util.List;

import com.bam.bs.dto.UserDto;
import com.bam.bs.dto.UserRequest;
import com.bam.bs.service.UserService;
import com.bam.bs.util.Message;
import com.bam.bs.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@ApiOperation(value = "Save User")
	public UserDto saveUser(@RequestBody UserDto userDto) {
		return userService.saveUser(userDto);
	}

	@PutMapping
	@ApiOperation(value = "Update User")
	public UserDto updateUser(@RequestBody UserDto userDto) {
		return userService.updateUser(userDto);
	}

	@GetMapping
	@ApiOperation(value = "Search Users")
	public List<UserDto> searchUsers(String userRequestString) {
		return userService.searchUsers(Utils.readValue(userRequestString, UserRequest.class));
	}

	@DeleteMapping
	@ApiOperation(value = "Delete User")
	public Message deleteUser(@RequestParam("ids[]") Long[] ids) {
		return userService.deleteUser(ids);
	}

}
