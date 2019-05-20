package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory{

	public static IPaymentRate createPaymentRateBoss() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth * 1.5;
			}
			@Override
			public String toString() {
				return "1.50";
			}
		};
	}

	public static IPaymentRate createPaymentRateEmployee() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth * 0.85;
			}
			@Override
			public String toString() {
				return "0.85";
			}
		};
	}
	
	public static IPaymentRate createPaymentRateManager() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth * 1.1;
			}
			@Override
			public String toString() {
				return "1.10";
			}
		};
	}

}
