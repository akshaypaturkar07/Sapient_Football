package com.sapient.footballdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FootballdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballdemoApplication.class, args);
	}

	/*@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption, @Value("${application-version}") String appVersion) {
		return new OpenAPI().info(new Info()
				.title("Order Detail API")
				.version(appVersion)
				.description(appDesciption)
				.termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));

	}*/
	@Bean
	//@LoadBalanced
	RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
