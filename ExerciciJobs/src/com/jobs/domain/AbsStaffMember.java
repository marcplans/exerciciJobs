package com.jobs.domain;

import java.util.List;

public abstract class AbsStaffMember {

	private int id;
	private String name;
	private String address;
	private String phone;
	private double totalPaid = 0;

	private static int COUNTER_MEMBERS = 1;

	public AbsStaffMember(String name, String address, String phone)
			throws Exception {
		if (name.equals(""))
			throw new Exception();
		if (address.equals(""))
			throw new Exception();
		if (phone.equals(""))
			throw new Exception();

		this.name = name;
		this.address = address;
		this.phone = phone;
		id = COUNTER_MEMBERS;
		COUNTER_MEMBERS++;
	}

	// Getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getTotalPaid() {
		return totalPaid;
	}

	protected void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}
	
	// To be implemented by subclasses
	public abstract void pay();
	
	public abstract List<String> toStringList();
	
}
