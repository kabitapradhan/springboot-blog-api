package com.blog.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.blog.entity.User;
import com.blog.repository.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserDaoLayerTest {
	
	@Autowired
	private UserRepository userRepo;
	
	// unit test for svae User
	@Test
	public void saveUser() {
		User user = User.builder().name("CCCCC").email("cc@gmail.com").password("12345").about("xxxx")
				.gender("mle").build();
		User save = this.userRepo.save(user);
		
		Assertions.assertThat(save.getName().equals("CCCCC"));
	}

}
