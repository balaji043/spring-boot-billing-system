package com.bam.bs.service.impl;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bam.bs.dto.BillDto;
import com.bam.bs.dto.BillRequest;
import com.bam.bs.dto.SearchBillResponse;
import com.bam.bs.entity.Bill;
import com.bam.bs.entity.Product;
import com.bam.bs.exception.CommonException;
import com.bam.bs.repository.BillRepository;
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
	public List<SearchBillResponse> searchBills(BillRequest billRequest) {
		List<SearchBillResponse> billResponses = new ArrayList<>();
		List<Bill> billList = null;
		if (billRequest.getIsAllBillRequest().booleanValue()) {
			billList = billRepository.findAll();
		} else {
			throw new CommonException("Haven't implemented!");
		}
		billList.stream().forEach(bill -> {
			SearchBillResponse billResponse = new SearchBillResponse();
			billResponse.setId(bill.getId());
			billResponse.setCustomerName(bill.getCustomer().getName());
			billResponse.setDate(bill.getCreationDate());
			billResponse.setInvoice(bill.getInvoiceName());
			billResponse.setPlace(bill.getCustomer().getCity());
			billResponse.setInvoiceAmount(getInvoiceAmount(bill));
			billResponse.setUserName(bill.getUser().getName());
		});
		return billResponses;
	}

	@Override
	public Message deleteBill(Long[] id) {
		billRepository.deleteAllById(id);
		return new Message(Messages.SUCCESS);
	}

	private Bill mapBill(BillDto billDto) {
		return modelMapper.map(billDto, Bill.class);
	}

	private String getInvoiceAmount(Bill bill) {
		double amount = 0.0;
		Iterator<Product> iterator = bill.getProducts().iterator();
		while (iterator.hasNext()) {
			amount = amount + iterator.next().getRate();
		}
		return "" + amount;
	}

}
