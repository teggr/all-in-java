package com.robintegg.demo.allinjavawebapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.robintegg.demo.allinjavawebapp.domain.UserService;
import com.robintegg.demo.allinjavawebapp.web.templates.HomeTemplate;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {

	private UserService userService;

	@GetMapping("/")
	public String getHome(Model model) {

		model.addAttribute("title", "Apply for all the things");
		model.addAttribute("users", userService.getUsers());

		return HomeTemplate.class.getSimpleName();

	}

}
