package com.cg.ems.service;

import java.util.List;


import com.cg.ems.entity.Payment;

public interface PaymentService {
	Payment savePayment(Payment payment);
	//return type is payment and method name is save payment- and return type is payment object
	List<Payment> getAllPayments();
	//List<Employee> getAllEmployees();
	Payment getPaymentById(long id);
	Payment updatePaymentById(Payment payment, long id);
	void deletePayment(long id);
}
