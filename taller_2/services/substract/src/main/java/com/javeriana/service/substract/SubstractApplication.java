package com.javeriana.service.substract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubstractApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubstractApplication.class, args);
	}

}
