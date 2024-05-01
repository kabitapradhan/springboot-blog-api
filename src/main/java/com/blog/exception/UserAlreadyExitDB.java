package com.blog.exception;

public class UserAlreadyExitDB extends RuntimeException{
	
	public UserAlreadyExitDB(String msg) {
		super(msg);
	}

}
