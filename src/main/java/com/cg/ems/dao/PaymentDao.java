package com.cg.ems.dao;

import org.springframework.data.repository.CrudRepository;

import com.cg.ems.entity.Payment;

public interface PaymentDao extends CrudRepository<Payment,Long>{

}
