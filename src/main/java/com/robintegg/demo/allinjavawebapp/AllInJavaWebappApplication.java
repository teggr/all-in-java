package com.robintegg.demo.allinjavawebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class AllInJavaWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllInJavaWebappApplication.class, args);
	}
}
