package com.blog.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.blog.response.Responsedata;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Responsedata> getUserNotFoundException(UserNotFoundException ex) {
		Responsedata res = new Responsedata();
		res.setMessage(ex.getMessage());
		res.setSuccess(false);
		return new ResponseEntity<Responsedata>(res , HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> getmsthod(MethodArgumentNotValidException ex) {
		Map<String ,String> map = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(err -> {
			String fname = ((FieldError) err).getField();
			String msg = err.getDefaultMessage();
			map.put(fname, msg);
		});
		return new ResponseEntity<Map<String,String>>(map , HttpStatus.BAD_REQUEST);
	}

}
