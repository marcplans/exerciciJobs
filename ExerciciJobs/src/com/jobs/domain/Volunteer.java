package com.jobs.domain;

import java.util.Arrays;
import java.util.List;

public class Volunteer extends AbsStaffMember {
	private String description;

	public Volunteer(String name, String address, String phone,
		String description) throws Exception {
		super(name, address, phone);
		this.description = description;
	}

	// Getters & setters
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void pay() {
		setTotalPaid(0);
	}

	public List<String> toStringList() {
		return Arrays.asList(String.valueOf(getId()), getName(),
			getAddress(), getPhone(), getDescription(), "---", "---",
			"---");
	}

	@Override
	public String toString() {
		return "Id: " + getId() + "\nName: " + getName()
			+ "\nAddress: " + getAddress() + "\nPhone: " + getPhone()
			+ "\nDescription: " + getDescription();
	}
}
