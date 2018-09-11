package com.wm.bcgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class BcgameApplication {
	public static void main(String[] args) {
		SpringApplication.run(BcgameApplication.class, args);

	}
}
