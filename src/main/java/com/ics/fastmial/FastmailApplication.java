package com.ics.fastmial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.ics.fastmial")
public class FastmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastmailApplication.class, args);
	}

}
