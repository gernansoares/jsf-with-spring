package com.jsfwithspring;

import com.jsfwithspring.config.JsfInitializer;
import jakarta.servlet.ServletContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.EnumSet;

@SpringBootApplication
public class JsfWithSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsfWithSpringApplication.class, args);
    }

    @Bean
    public ServletContextInitializer facesInitializer() {
        return new JsfInitializer();
    }

}
