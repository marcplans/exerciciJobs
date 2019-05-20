package com.jobs.domain;

public interface IPaymentRate {
	public double pay(double salaryPerMonth);
	public String toString();
		// Added toString method to print out rate.
}
