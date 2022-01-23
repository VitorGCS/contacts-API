package com.webApp.demo.webApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebAppApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WebAppApplication.class);
		app.setBanner((environment, sourceClass, out) -> {
			out.println("======= API Marketing =======");
		});
		app.run(args);
	}
}
