package com.robintegg.demo.allinjavawebapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.robintegg.demo.allinjavawebapp.web.templates.HomeTemplate;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(Model model) {

        model.addAttribute("title", "Home is here");

        return HomeTemplate.class.getSimpleName();

    }

}
