package com.as.order.domain;

public class Customer {
	private String name;
	private String state;
	
	public Customer(String name, String state) {
		this.name = name;
		this.state = state;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getState() {
		return state;
	}
	
	public void setId(String state) {
		this.state = state;
	}

}
