package com.myapp.microservices.myappuserserver;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MyappUser {
	
	private long id;
	private String userId;
	private String userName;
	private List<Integer> supplierList;
	
	protected MyappUser() {
		
	}

	public MyappUser(long id, String userId, String userName, List<Integer> supplierList) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.supplierList = supplierList;
	}
	
	
	
	

}
