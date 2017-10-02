package com.robintegg.demo.allinjavawebapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

import com.robintegg.j2html.spring4.J2HtmlConfigurer;
import com.robintegg.j2html.spring4.J2HtmlViewResolver;

@Configuration
public class J2HtmlConfiguration {

    @Bean
    public J2HtmlConfigurer j2HtmlConfigurer() {
        J2HtmlConfigurer j2HtmlConfigurer = new J2HtmlConfigurer();
        j2HtmlConfigurer.setTemplatePackage("com.robintegg.demo.allinjavawebapp.web.templates");
        return j2HtmlConfigurer;
    }

    @Bean
    public ViewResolver viewResolver() {
        return new J2HtmlViewResolver();
    }

}
