package com.bam.bs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bam.bs.dto.CustomerDto;
import com.bam.bs.dto.CustomerRequest;
import com.bam.bs.entity.Customer;
import com.bam.bs.exception.CommonException;
import com.bam.bs.repository.CustomerRepository;
import com.bam.bs.service.CustomerService;
import com.bam.bs.util.CustomerType;
import com.bam.bs.util.Message;
import com.bam.bs.util.Messages;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		Customer customer = mapCustomer(customerDto);
		customerRepository.save(customer);
		if (customer.getId() != null)
			return mapCustomer(customer);
		else
			throw new CommonException();
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) {
		return mapCustomer(customerRepository.save(mapCustomer(customerDto)));
	}

	@Override
	public List<CustomerDto> searchCustomers(CustomerRequest customerRequest) {
		List<Customer> customers;
		if (customerRequest.getCustomerType().equals(CustomerType.BOTH)) {
			customers = customerRepository.findAll();
		} else {
			customers = customerRepository.findAllByCustomerType(customerRequest.getCustomerType());
		}
		return customers.stream().map(this::mapCustomer).collect(Collectors.toList());
	}

	@Override
	public List<CustomerDto> fuzzyCustomers(String name) {
		return customerRepository.findByNameLikeIgnoreCase(name).stream().map(this::mapCustomer).collect(Collectors.toList());
	}

	@Override
	public Message deleteCustomer(Long[] ids) {
		customerRepository.deleteAllById(ids);
		return new Message(Messages.SUCCESS);
	}

	private Customer mapCustomer(CustomerDto customerDto) {
		return modelMapper.map(customerDto, Customer.class);
	}

	private CustomerDto mapCustomer(Customer customer) {
		return modelMapper.map(customer, CustomerDto.class);
	}

}
