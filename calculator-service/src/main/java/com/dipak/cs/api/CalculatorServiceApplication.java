package com.dipak.cs.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.dipak.cs.api.entity.Operation;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author Dipak
 * @apiNote This class is responsible for creating all objects, dependency
 *          injection and managing the life cycle of all beans
 */

@SpringBootApplication
public class CalculatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorServiceApplication.class, args);
	}

	
}
