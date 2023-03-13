package javeriana.service.add;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AddApplication {
	public static void main(String[] args) {
		SpringApplication.run(AddApplication.class, args);
	}

}
