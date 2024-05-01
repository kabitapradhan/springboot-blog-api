package com.blog.service;

import java.util.List;

import com.blog.payload.UserDto;

public interface UserService {
	
	public UserDto createUser(UserDto dto);
	public List<UserDto> getAllser();
	public UserDto getUserById(Integer userId);
	public UserDto updateUser(Integer userId , UserDto dto);
	public void deleteUser(Integer userId);

}
