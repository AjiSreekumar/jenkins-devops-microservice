package com.myapp.microservices.myappuserserver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MyappUserController {
	
	@Autowired
	private MyappUserService myappUserService;
	
	@GetMapping("/")
	public String isHealthy() {
		return "{healthy:true}";
	}
	
	@GetMapping("/users/{userId}/suppliers")
	public List<Integer> getSuppliersOfUser(@PathVariable String userId) {
		log.debug("Find suppliers for user "+userId);
		return myappUserService.findSuppliersByUser(userId);
	}
	
	@GetMapping("/users")
	public List<MyappUser> getUsers() {
		log.error("This is a test for Datadog");
		return myappUserService.getUsers();
	}

}
