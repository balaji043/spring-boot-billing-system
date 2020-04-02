package com.bam.bs.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bam.bs.dto.BillDto;
import com.bam.bs.dto.BillRequest;
import com.bam.bs.entity.Bill;
import com.bam.bs.entity.Customer;
import com.bam.bs.entity.User;
import com.bam.bs.exception.CommonException;
import com.bam.bs.repository.BillRepository;
import com.bam.bs.repository.CustomerRepository;
import com.bam.bs.repository.UserRepository;
import com.bam.bs.service.BillService;
import com.bam.bs.util.Message;
import com.bam.bs.util.Messages;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public Bill saveBill(BillDto billDto) {
		Bill bill = mapBill(billDto);
		bill.getProducts().stream().forEach(e -> e.setBill(bill));
		Optional<Customer> customer = customerRepository.findById(billDto.getCustomerId());
		Optional<User> user = userRepository.findById(billDto.getUserId());

		if (customer.isPresent() && user.isPresent()) {

			bill.setCustomer(customer.get());
			bill.setUser(user.get());

			billRepository.save(bill);

			if (bill.getId() != null)
				return bill;
			else
				throw new CommonException();
		}
		throw new CommonException();
	}

	@Override
	public Bill updateBill(BillDto billDto) {
		Bill bill = mapBill(billDto);
		bill.getProducts().stream().forEach(e -> e.setBill(bill));
		billRepository.save(bill);
		return bill;
	}

	@Override
	public List<BillDto> searchBills(BillRequest billRequest) {
		return billRepository.findAll().stream().map(this::mapBill).collect(Collectors.toList());
	}

	@Override
	public Message deleteBill(Long[] id) {
		billRepository.deleteAllById(id);
		return new Message(Messages.SUCCESS);
	}

	private Bill mapBill(BillDto billDto) {
		return modelMapper.map(billDto, Bill.class);
	}

	private BillDto mapBill(Bill bill) {
		return modelMapper.map(bill, BillDto.class);
	}

}
