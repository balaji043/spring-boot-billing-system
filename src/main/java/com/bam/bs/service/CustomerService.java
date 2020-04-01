package com.bam.bs.service;

import java.util.List;

import com.bam.bs.dto.CustomerDto;
import com.bam.bs.dto.CustomerRequest;
import com.bam.bs.entity.Customer;
import com.bam.bs.util.Message;

public interface CustomerService {

	Customer saveCustomer(CustomerDto customerDto);

	Customer updateCustomer(CustomerDto customerDto);

	List<CustomerDto> searchCustomers(CustomerRequest customerRequest);

	Message deleteCustomer(Long[] ids);


}
