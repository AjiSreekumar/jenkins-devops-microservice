package com.msdp.microservices.msdpportaluserserver;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MsdpUser {
	
	private long id;
	private String userId;
	private String userName;
	private List<Integer> supplierList;
	
	protected MsdpUser() {
		
	}

	public MsdpUser(long id, String userId, String userName, List<Integer> supplierList) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.supplierList = supplierList;
	}
	
	
	
	

}
