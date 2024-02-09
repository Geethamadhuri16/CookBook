package com.cookBook.CookBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cookBook.CookBook")
public class CookBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookBookApplication.class, args);
	}

}
