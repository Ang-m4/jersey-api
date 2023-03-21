package com.javeriana.service.subtract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubtractApplication {
	public static void main(String[] args) {
		SpringApplication.run(SubtractApplication.class, args);
	}
}
