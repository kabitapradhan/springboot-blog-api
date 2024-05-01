package com.blog.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payload.UserDto;
import com.blog.response.Responsedata;
import com.blog.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="http://127.0.0.1:5500/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto){
		UserDto user = this.userService.createUser(dto);
		return new ResponseEntity<>(user , HttpStatus.CREATED);	
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAlluser(){
		List<UserDto> list = this.userService.getAllser();
		return new ResponseEntity<>(list , HttpStatus.OK);	
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer id){
		UserDto dto = this.userService.getUserById(id);
		return new ResponseEntity<>(dto , HttpStatus.OK);	
	}
	@PostMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto dto ,@PathVariable("id") Integer id){
		UserDto user = this.userService.updateUser(id , dto);
		return new ResponseEntity<>(user , HttpStatus.CREATED);	
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
		this.userService.deleteUser(id);
		Responsedata res = new Responsedata();
		res.setSuccess("Delete user data successfull");
		res.setBol(true);
		return new ResponseEntity<>(res , HttpStatus.CREATED);	
	}


}
