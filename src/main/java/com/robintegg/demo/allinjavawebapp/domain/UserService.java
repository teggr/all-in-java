package com.robintegg.demo.allinjavawebapp.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
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
	private RepositoryService repositoryService;
	private RuntimeService runtimeService;
	private TaskService taskService;

	public User createUser(User user) {

		log.info("event=CREATING_A_USER");

		user = userRepository.save(user);

		Map<String, Object> map = new HashMap<>();
		map.put("firstName", user.getFirstName());
		audit.add(new AuditEvent("system", "CREATING_A_USER", map));

		log.info("Number of process definitions : {}", repositoryService.createProcessDefinitionQuery().count());
		log.info("Number of tasks : {}", taskService.createTaskQuery().count());
		runtimeService.startProcessInstanceByKey("oneTaskProcess");
		log.info("Number of tasks after process start: {}", taskService.createTaskQuery().count());

		return user;

	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

}
