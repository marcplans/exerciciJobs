package com.jobs.domain;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.List;

public class Employee extends AbsStaffMember {

	private double salaryPerMonth;
	private IPaymentRate paymentRate;
	private String category;

	public Employee(String name, String address, String phone,
		String category, double salaryPerMonth,
		IPaymentRate paymentRate) throws Exception {

		super(name, address, phone);

		if (salaryPerMonth < 0)
			throw new Exception(
				"Salary per month can not be negative");

		if (paymentRate == null)
			throw new Exception("Payment rate can not be null");

		this.salaryPerMonth = salaryPerMonth;
		this.paymentRate = paymentRate;
		this.category = category;
	}

	// Getters & setters.
	public double getSalaryPerMonth() {
		return salaryPerMonth;
	}

	public void setSalaryPerMonth(double salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}

	public IPaymentRate getPaymentRate() {
		return paymentRate;
	}

	public void setPaymentRate(IPaymentRate paymentRate) {
		this.paymentRate = paymentRate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public void pay() {
		setTotalPaid(paymentRate.pay(salaryPerMonth));
	}

	// Returns a String List to be printed out.
	public List<String> toStringList() {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
		otherSymbols.setDecimalSeparator(',');
		otherSymbols.setGroupingSeparator('.');
		DecimalFormat myFormat = new DecimalFormat("###,##0.00 €",
			otherSymbols);
		return Arrays.asList(String.valueOf(getId()), getName(),
			getAddress(), getPhone(), getCategory(),
			String.valueOf(myFormat.format(getSalaryPerMonth())),
			getPaymentRate().toString(),
			String.valueOf(myFormat.format(getTotalPaid())));
	}

	@Override
	public String toString() {
		return "Id: " + getId() + "\nName: " + getName()
			+ "\nAddress: " + getAddress() + "\nPhone: " + getPhone()
			+ "\nCategory: " + getCategory() + "\nSalary: "
			+ getSalaryPerMonth() + "\nRate: "
			+ getPaymentRate().toString() + "\nTotal paid: "
			+ getTotalPaid();
	}

}
