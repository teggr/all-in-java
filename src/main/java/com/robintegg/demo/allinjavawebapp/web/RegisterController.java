package com.robintegg.demo.allinjavawebapp.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.robintegg.demo.allinjavawebapp.domain.User;
import com.robintegg.demo.allinjavawebapp.domain.UserService;
import com.robintegg.demo.allinjavawebapp.web.templates.RegisterHomeTemplate;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RegisterController {

	private UserService userService;

	@GetMapping("/register")
	public String getHome(Model model) {

		model.addAttribute("title", "Home is here");

		return RegisterHomeTemplate.class.getSimpleName();

	}

	@PostMapping("/register")
	public String createUser(@Valid @ModelAttribute User user, Model model) {

		userService.createUser(user);

		return "redirect:/";

	}

}
