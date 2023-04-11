package com.cg.ems;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//
//@ComponentScan(basePackages = {"com.cg.ems"})
@Configuration
//@EnableAutoConfiguration
//@EnableValidation
public class EMS {

	public static void main(String[] args) {
		SpringApplication.run(EMS.class, args);
	}
     
	/*@Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        return validatorFactory.getValidator();
    } */
	
	
}
