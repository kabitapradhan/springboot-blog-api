package com.blog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Integer id;
	@NotNull(message = "User name can not be null.")
	@NotEmpty(message = "User name must be enter.")
	@Size(min = 2 , max = 20 ,message = "User name must be min 2 and max 20 character.")
	private String name;
	@Email
	
	private String email;
	@NotNull(message = "password must no be null")
	@NotEmpty(message = "password must no be empty")
	@Size(min = 2 , max = 8 ,message = "password min 2 and max 8 charac")
	private String password;
	private String about;

}
