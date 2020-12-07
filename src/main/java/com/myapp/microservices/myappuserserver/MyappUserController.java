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
		log.info("100.80.302- doing health check");
		return "{healthy:true}";
	}
	
	@GetMapping("/users/{userId}/suppliers")
	public List<Integer> getSuppliersOfUser(@PathVariable String userId) {
		log.debug("100.80.201-Find suppliers for user "+userId);
		log.error("100.80.101-This is a test for Datadog users");
		return myappUserService.findSuppliersByUser(userId);
	}
	
	@GetMapping("/users")
	public List<MyappUser> getUsers() {
		log.error("100.80.102-This is a test for Datadog");
		return myappUserService.getUsers();
	}

}
