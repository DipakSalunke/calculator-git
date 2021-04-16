package com.dipak.cs.api.swagger;


import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class is used for the configuration and customization of swagger. It
 * will show the person details whom user can connect if having any queries. We
 * use swagger to make the documentation part easy and user will able to see the
 * endpoints to access the application.
 *
 * @version 1
 * @author Dipak
 */

@Configuration
@EnableSwagger2

public class SwaggerConfig {
	/**
	 * We are creating a Docket bean in a Spring Boot configuration to configure
	 * Swagger 2 for the application. A Springfox Docket instance provides the
	 * primary API configuration with sensible defaults and convenience methods for
	 * configuration
	 * 
	 */
	@Bean
	public Docket api() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiDetails());
		return docket;
	}

	/**
	 * This call is used to give the API details in which we can configure the
	 * person details. A user can reach out to that person if having any queries by
	 * looking at these API details.
	 */
	private ApiInfo apiDetails() {
		ApiInfo apiInfo = new ApiInfo("Calculator Service", "Calculator Service", "1.0", "Free to use",
				new springfox.documentation.service.Contact("Dipak Salunke", "http://www.google.com", "Dipakbs810@gmail.com"),
				"API License", "http://license.com", Collections.emptyList());
		return apiInfo;
	}
}