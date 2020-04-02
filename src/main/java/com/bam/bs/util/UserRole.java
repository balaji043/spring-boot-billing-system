package com.bam.bs.util;

public enum UserRole {
	ADMIN("ADMIN"), EMPLOYEE("EMPLOYEE");

	private String value;

	UserRole(String value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
