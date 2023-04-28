package com.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.Customer;
import com.spring.rest.exception.CustomerNotFound;
import com.spring.rest.entity.Error;

@RestController
@RequestMapping("/api")
public class HomeController {

	@GetMapping("/test")
	public String helloAPI() {
		return "This API is UP and RUNNING";
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(0, "Sanat", "Dey",9382070426L,"Station Road Jhalda"));
		customers.add(new Customer(1, "Manik", "Dey",9932903425L,"Station Road Jhalda"));
		customers.add(new Customer(2, "Mayna", "Dey",9800495802L,"Station Road Jhalda"));
		customers.add(new Customer(3, "Goutam", "Dey",9832906618L,"Hatoyara , Purulia"));
		
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
	
	//@RequestMapping(value="/customer/{id}",method=RequestMethod.GET)
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		
		if(id > 3 || id<=-1) {
			throw new CustomerNotFound("The customer id - "+ id + " Not Found.");
		}
		
		return new ResponseEntity<>(new Customer(id, "Goutam", "Dey",9832906618L,"Hatoyara , Purulia"),HttpStatus.OK);
	}
	
}
