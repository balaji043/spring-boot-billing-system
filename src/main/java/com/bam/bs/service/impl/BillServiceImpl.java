package com.bam.bs.service.impl;

import java.time.format.DateTimeFormatter;
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
		billRepository.save(bill);
		if (bill.getId() != null) {
			String s = bill.getCreationDate().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
			bill.setInvoiceName(String.format("BS-%s%05d", s, bill.getId()));
			billRepository.save(bill);
			return bill;
		} else {
			throw new CommonException();
		}
	}

	@Override
	public Bill updateBill(BillDto billDto) {
		Bill bill = mapBill(billDto);
		bill.getProducts().stream().forEach(e -> e.setBill(bill));
		billRepository.save(bill);
		if (bill.getId() != null)
			return bill;
		else
			throw new CommonException();
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
		Bill bill = modelMapper.map(billDto, Bill.class);
		Optional<Customer> customer = customerRepository.findById(billDto.getCustomerId());
		Optional<User> user = userRepository.findById(billDto.getUserId());

		if (customer.isPresent() && user.isPresent()) {
			bill.setCustomer(customer.get());
			bill.setUser(user.get());
		} else {
			if (!customer.isPresent() && !user.isPresent()) {
				throw new CommonException("CustomerId and UserId  are Not Present");
			} else if (!customer.isPresent()) {
				throw new CommonException("CustomerId is Not Present");
			} else {
				throw new CommonException("UserId is Not Present");
			}
		}
		return bill;
	}

	private BillDto mapBill(Bill bill) {
		BillDto billDto = modelMapper.map(bill, BillDto.class);
		billDto.setCustomerId(bill.getCustomer().getId());
		billDto.setUserId(bill.getUser().getId());
		return billDto;
	}

}
