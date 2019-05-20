package com.jobs.persistence;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;

public class EmployeeRepository {

	private static List<AbsStaffMember> members = new ArrayList<>();

	public EmployeeRepository() {
	}

	public static List<AbsStaffMember> getMembers() {
		return members;
	}

	public List<AbsStaffMember> getAllMembers() {
		return getMembers();
	}

	// Returns a list of volunteers.
	public List<AbsStaffMember> getVolunteers() {
		List<AbsStaffMember> outputList = new ArrayList<>();
		for (AbsStaffMember member : getMembers()) {
			if (member.getClass().getSimpleName()
				.equals("Volunteer")) {
				outputList.add(member);
			}
		}
		return outputList;
	}

	// Returns a list of basic employees, bosses
	// and managers not included.
	public List<AbsStaffMember> getBasicEmployees() {
		return getEmployee("Employee");
	}

	// Returns a list of manager employees.
	public List<AbsStaffMember> getManagers() {
		return getEmployee("Manager");
	}

	// Returns a list of boss employees.
	public List<AbsStaffMember> getBosses() {
		return getEmployee("Boss");
	}

	private List<AbsStaffMember> getEmployee(String category) {
		List<AbsStaffMember> outputList = new ArrayList<>();
		for (AbsStaffMember member : getMembers()) {
			if (member.getClass().getSimpleName().equals("Employee")
				&& ((Employee) member).getCategory()
					.contentEquals(category)) {
				outputList.add(member);
			}
		}
		return outputList;
	}

	public void addMember(AbsStaffMember member) throws Exception {
		if (member == null)
			throw new Exception();
		getMembers().add(member);
	}

}
