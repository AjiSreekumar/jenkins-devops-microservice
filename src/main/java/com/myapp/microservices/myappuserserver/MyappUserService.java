package com.myapp.microservices.myappuserserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MyappUserService {
	
	private static List<MyappUser> users = new ArrayList<MyappUser>();
	
	static List<Integer> myuserSupplierList = new ArrayList<>(
		    Arrays.asList(100, 102)
		);
	
	static List<Integer> testuserSupplierList = new ArrayList<>(
		    Arrays.asList(101, 103)
		);
	
	static {
		users.add(new MyappUser(1L, "myuser", "myuser", myuserSupplierList));
		users.add(new MyappUser(2L, "testuser", "testuser", testuserSupplierList));
	}

	public List<Integer> findSuppliersByUser(String userId) {
		for(MyappUser myappUser : users) {
			if(myappUser.getUserId().equalsIgnoreCase(userId)) {
				return myappUser.getSupplierList();
			}
		}
		return new ArrayList<Integer>();
	}
	
	public List<MyappUser> getUsers(){
		return users;
	}

}
