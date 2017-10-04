package com.robintegg.demo.allinjavawebapp.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class UserService {

	private AuditEventRepository audit;
	private UserRepository userRepository;

	public User createUser(User user) {

		log.info("event=CREATING_A_USER");

		// User user = new
		// User.UserBuilder().firstName("robin").age(38).build();

		user = userRepository.save(user);

		Map<String, Object> map = new HashMap<>();
		map.put("firstName", user.getFirstName());
		audit.add(new AuditEvent("system", "CREATING_A_USER", map));

		return user;

	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

}
