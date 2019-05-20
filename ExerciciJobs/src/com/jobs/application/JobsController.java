package com.jobs.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;
import com.jobs.tools.Tools;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();

	public JobsController() {
	}

	public void createBossEmployee(String name, String address,
		String phone, double salaryPerMonth) throws Exception {
		Employee boss = new Employee(name, address, phone, "Boss",
			salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}

	public void createEmployee(String name, String address,
		String phone, double salaryPerMonth) throws Exception {
		Employee employee = new Employee(name, address, phone,
			"Employee", salaryPerMonth,
			PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address,
		String phone, double salaryPerMonth) throws Exception {
		Employee manager = new Employee(name, address, phone,
			"Manager", salaryPerMonth,
			PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
	}

	public void payAllEmployeers() {
		for (AbsStaffMember employee : repository.getAllMembers()) {
			employee.pay();
		}
	}
	
	public void createVolunteer(String name, String address,
		String phone) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone,
			"Volunteer");
		repository.addMember(volunteer);
	}

	public String getAllEmployees() {
		return getStringToPrint(repository.getAllMembers());
	}

	public String getVolunteers() {
		return getStringToPrint(repository.getVolunteers());
	}

	public String getBasicEmployees() {
		return getStringToPrint(repository.getBasicEmployees());
	}

	public String getManagers() {
		return getStringToPrint(repository.getManagers());
	}

	public String getBosses() {
		return getStringToPrint(repository.getBosses());
	}

	public String getPaidEmployees() {
		List<AbsStaffMember> paidEmployees = new ArrayList<>();
		paidEmployees.addAll(repository.getBosses());
		paidEmployees.addAll(repository.getManagers());
		paidEmployees.addAll(repository.getBasicEmployees());
		return getStringToPrint(paidEmployees);
	}

	public String getStringToPrint(
		List<AbsStaffMember> staffToPrint) {
		List<Integer> stringSpacing = Arrays.asList(6, 20, 40, 15, 12,
			-12, -12, -15);
		String outputString = Tools.tableHeader(
			Arrays.asList("Id", "Name", "Address", "Phone",
				"Category", "Salary", "Rate", "Total Paid"),
			stringSpacing);
		for (AbsStaffMember member : staffToPrint) {
			outputString += "\n" + Tools
				.stringLine(member.toStringList(), stringSpacing);
		}
		return outputString;
	}

}
