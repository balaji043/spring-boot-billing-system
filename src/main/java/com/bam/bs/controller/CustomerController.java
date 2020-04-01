package com.bam.bs.controller;

import java.util.List;

import com.bam.bs.dto.CustomerDto;
import com.bam.bs.dto.CustomerRequest;
import com.bam.bs.entity.Customer;
import com.bam.bs.service.CustomerService;
import com.bam.bs.util.Message;
import com.bam.bs.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	@ApiOperation(value = "Save Customer")
	public Customer saveCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.saveCustomer(customerDto);
	}

	@PutMapping
	@ApiOperation(value = "Update Customer")
	public Customer updateCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.updateCustomer(customerDto);
	}

	@GetMapping
	@ApiOperation(value = "Search Customers")
	public List<CustomerDto> searchCustomers(String customerRequestString) {
		return customerService.searchCustomers(Utils.readValue(customerRequestString, CustomerRequest.class));
	}

	@DeleteMapping
	@ApiOperation(value = "Delete Customer")
	public Message deleteCustomer(@RequestParam("ids[]") Long[] ids) {
		return customerService.deleteCustomer(ids);
	}

}
