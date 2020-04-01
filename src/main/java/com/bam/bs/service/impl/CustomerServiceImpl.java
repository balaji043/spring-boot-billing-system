package com.bam.bs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.bam.bs.dto.CustomerDto;
import com.bam.bs.dto.CustomerRequest;
import com.bam.bs.entity.Customer;
import com.bam.bs.exception.CommonException;
import com.bam.bs.repository.CustomerRepository;
import com.bam.bs.service.CustomerService;
import com.bam.bs.util.Message;
import com.bam.bs.util.Messages;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public Customer saveCustomer(CustomerDto customerDto) {
		Customer customer = mapCustomer(customerDto);
		customerRepository.save(customer);
		if (customer.getId() != null)
			return customer;
		else
			throw new CommonException();
	}

	@Override
	public Customer updateCustomer(CustomerDto customerDto) {
		return customerRepository.save(mapCustomer(customerDto));
	}

	@Override
	public List<CustomerDto> searchCustomers(CustomerRequest customerRequest) {
		return customerRepository.findAll().stream().map(this::mapCustomer).collect(Collectors.toList());
	}

	@Override
	public Message deleteCustomer(Long[] id) {
		customerRepository.deleteAllById(id);
		return new Message(Messages.SUCCESS);
	}

	private Customer mapCustomer(CustomerDto customerDto) {
		return modelMapper.map(customerDto, Customer.class);
	}

	private CustomerDto mapCustomer(Customer customer) {
		return modelMapper.map(customer, CustomerDto.class);
	}
}
