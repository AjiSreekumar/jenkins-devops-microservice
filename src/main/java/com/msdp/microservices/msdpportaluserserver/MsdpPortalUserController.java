package com.msdp.microservices.msdpportaluserserver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsdpPortalUserController {
	
	@Autowired
	private MsdpUserService msdpUserService;
	
	@GetMapping("/users/{userId}/suppliers")
	public List<Integer> getSuppliersOfUser(@PathVariable String userId) {
		
		return msdpUserService.findSuppliersByUser(userId);
	}
	
	@GetMapping("/users")
	public List<MsdpUser> getUsers() {
		
		return msdpUserService.getUsers();
	}

}
