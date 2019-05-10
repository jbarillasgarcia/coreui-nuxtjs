package com.wau.genesis.jwtauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = { "com.wau.genesis.core.model" })
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}

