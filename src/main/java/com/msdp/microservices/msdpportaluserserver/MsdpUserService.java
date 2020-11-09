package com.msdp.microservices.msdpportaluserserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MsdpUserService {
	
	private static List<MsdpUser> users = new ArrayList<MsdpUser>();
	
	static List<Integer> myuserSupplierList = new ArrayList<>(
		    Arrays.asList(100, 102)
		);
	
	static List<Integer> testuserSupplierList = new ArrayList<>(
		    Arrays.asList(101, 103)
		);
	
	static {
		users.add(new MsdpUser(1L, "myuser", "myuser", myuserSupplierList));
		users.add(new MsdpUser(2L, "testuser", "testuser", testuserSupplierList));
	}

	public List<Integer> findSuppliersByUser(String userId) {
		for(MsdpUser msdpUser : users) {
			if(msdpUser.getUserId().equalsIgnoreCase(userId)) {
				return msdpUser.getSupplierList();
			}
		}
		return new ArrayList<Integer>();
	}
	
	public List<MsdpUser> getUsers(){
		return users;
	}

}
