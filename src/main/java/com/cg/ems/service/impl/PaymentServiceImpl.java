package com.cg.ems.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import com.cg.ems.exception.ResourceNotFoundException;
import com.cg.ems.dao.PaymentDao;
import com.cg.ems.entity.Payment;
import com.cg.ems.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService  {
	 private PaymentDao paymentDao;
	 public PaymentServiceImpl(PaymentDao paymentDao) {
	        this.paymentDao = paymentDao;
	    }

	    @Override
	    public Payment savePayment(Payment payment) {
	        return paymentDao.save(payment);
	    }


	    @Override
	    public List<Payment> getAllPayments() {
	        return (List<Payment>) paymentDao.findAll();
	    }


		@Override
		public Payment getPaymentById(long id) {
			//findbyid will be stored in optional object
			Optional<Payment> payment= paymentDao.findById(id);
			if(payment.isPresent()) {
				return payment.get();
			}
			else {
				throw new ResourceNotFoundException("Payment", "Id", id);
			}

		}

		@Override
		public Payment updatePaymentById(Payment payment, long id) {
			//check if id is present or not
			
	Payment existingpayment = paymentDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment", "Id", id));
			
			existingpayment.setPaymentId(payment.getPaymentId());
			existingpayment.setAmount(payment.getAmount());
			existingpayment.setStatus(payment.getStatus());
			existingpayment.setDate(payment.getDate());
			
			paymentDao.save(existingpayment);
			
			return existingpayment;
			
		}
		
		
	//	
		@Override
		public void deletePayment(long id) {
			// TODO Auto-generated method stub
			paymentDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment", "Id", id));
			
			 paymentDao.deleteById(id);
		}

	}
