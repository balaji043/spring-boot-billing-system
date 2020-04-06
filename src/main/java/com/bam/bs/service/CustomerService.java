package com.bam.bs.service;

import java.util.List;

import com.bam.bs.dto.CustomerDto;
import com.bam.bs.dto.CustomerRequest;
import com.bam.bs.util.Message;

public interface CustomerService {

	CustomerDto saveCustomer(CustomerDto customerDto);

	CustomerDto updateCustomer(CustomerDto customerDto);

	List<CustomerDto> searchCustomers(CustomerRequest customerRequest);

	Message deleteCustomer(Long[] ids);

}
