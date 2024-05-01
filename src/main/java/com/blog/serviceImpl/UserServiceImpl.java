package com.blog.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.User;
import com.blog.exception.UserAlreadyExitDB;
import com.blog.exception.UserNotFoundException;
import com.blog.payload.UserDto;
import com.blog.repository.UserRepository;
import com.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto createUser(UserDto dto) {
		
//		Optional<User> optional = this.userRepo.findById(dto.getId());
//		
//		if(optional.isPresent()) {
//			throw new UserAlreadyExitDB("user already present in DB: with id : " + dto.getId());
//		} else {
//			User user = this.mapper.map(dto, User.class);
//			User user2 = this.userRepo.save(user);
//			return this.mapper.map(user2, UserDto.class);
//		}
		User user = this.mapper.map(dto, User.class);
		User user2 = this.userRepo.save(user);
		return this.mapper.map(user2, UserDto.class);
		
	}

	@Override
	public List<UserDto> getAllser() {
		List<User> list = this.userRepo.findAll();
		List<UserDto> collect = list.stream().map(mp  -> this.mapper.map(mp,UserDto.class)).collect(Collectors.toList());
		
		return collect;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new UserNotFoundException("User not found : " + userId));
		
		return this.mapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(Integer userId, UserDto dto) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new UserNotFoundException("User not found : " + userId));
		user.setAbout(dto.getAbout());
		user.setName(dto.getName());
		User save = this.userRepo.save(user);
		
		return this.mapper.map(save, UserDto.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new UserNotFoundException("User not found : " + userId));
		this.userRepo.delete(user);
		
	}

}
