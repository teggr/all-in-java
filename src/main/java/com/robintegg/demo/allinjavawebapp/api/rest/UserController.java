package com.robintegg.demo.allinjavawebapp.api.rest;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robintegg.demo.allinjavawebapp.domain.User;
import com.robintegg.demo.allinjavawebapp.domain.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@Slf4j
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@PostMapping
	public Resource<User> createUser(User user) {

		log.info("creating user");

		return new Resource<User>(user);
	}

	@GetMapping
	public Resources<Resource<User>> getUsers() {

		log.info("getting users");

		return Resources.wrap(userService.getUsers());
	}

}
