package com.cg.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.entity.Payment;
import com.cg.ems.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	// constructor injection similar to the service class/layer

	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	// build create employee Rest api
	@PostMapping("/{save}")
	public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
		return new ResponseEntity<Payment>(paymentService.savePayment(payment), HttpStatus.CREATED);
	}

	// build get all employees REST API
	@GetMapping
	public List<Payment> getAllPayments() {
		return paymentService.getAllPayments();
	}

	// build get employee by id
	@GetMapping("{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("id") long pid) {

		return new ResponseEntity<Payment>(paymentService.getPaymentById(pid), HttpStatus.OK);

	}

	// build update employee REST API
	@PutMapping("/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable("id") long id, @RequestBody Payment payment) {
		return new ResponseEntity<Payment>(paymentService.updatePaymentById(payment, id), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePayment(@PathVariable("id") long id) {
		// delete emp from database
		paymentService.deletePayment(id);
		return new ResponseEntity<String>("Payment by id  deleted successfully", HttpStatus.OK);
	}

}
