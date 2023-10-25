package com.sb;


import com.sb.controller.ItemResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JerseySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JerseySpringBootApplication.class, args);
	}


	@Bean
	public ResourceConfig resourceConfig() {
		return new ResourceConfig().register(ItemResource.class);
	}
}
