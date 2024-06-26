package com.implement.spring.security;

import com.implement.spring.security.entity.User;
import com.implement.spring.security.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityApplication {

	@Autowired
	UserRepository userRepository;

	@PostConstruct
	public void initUsers(){
		List<User> users = Stream.of(
				new User(1,"Mayank","Sankhla","mayanksankhla221@gmail.com"),
				new User(2,"TopGun","Maverick","topgunmaverick@gmail.com"),
				new User(3,"Sherlock","Holmes","sherlockholmes@gmail.com")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

}
