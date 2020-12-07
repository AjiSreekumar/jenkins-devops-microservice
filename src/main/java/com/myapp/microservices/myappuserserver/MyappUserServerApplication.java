package com.myapp.microservices.myappuserserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class MyappUserServerApplication {

	public static void main(String[] args) {
		log.info("100.80.301-Application started");
		SpringApplication.run(MyappUserServerApplication.class, args);
	}

}
