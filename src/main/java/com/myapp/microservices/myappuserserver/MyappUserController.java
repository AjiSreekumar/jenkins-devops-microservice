package com.myapp.microservices.myappuserserver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyappUserController {
	
	@Autowired
	private MyappUserService myappUserService;
	
	@GetMapping("/")
	public String isHealthy() {
		return "{healthy:true}";
	}
	
	@GetMapping("/users/{userId}/suppliers")
	public List<Integer> getSuppliersOfUser(@PathVariable String userId) {
		
		return myappUserService.findSuppliersByUser(userId);
	}
	
	@GetMapping("/users")
	public List<MyappUser> getUsers() {
		
		return myappUserService.getUsers();
	}

}
