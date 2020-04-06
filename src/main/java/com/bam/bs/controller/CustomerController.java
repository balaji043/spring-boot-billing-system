package com.bam.bs.controller;

import java.util.List;

import com.bam.bs.dto.CustomerDto;
import com.bam.bs.dto.CustomerRequest;
import com.bam.bs.service.CustomerService;
import com.bam.bs.util.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	@ApiOperation(value = "Save Customer")
	public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.saveCustomer(customerDto);
	}

	@PutMapping
	@ApiOperation(value = "Update Customer")
	public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.updateCustomer(customerDto);
	}

	@PostMapping("/search")
	@ApiOperation(value = "Search Customers")
	public List<CustomerDto> searchCustomers(@RequestBody CustomerRequest customerRequestString) {
		return customerService.searchCustomers(customerRequestString);
	}

	@DeleteMapping
	@ApiOperation(value = "Delete Customer")
	public Message deleteCustomer(@RequestParam("ids[]") Long[] ids) {
		return customerService.deleteCustomer(ids);
	}

}
