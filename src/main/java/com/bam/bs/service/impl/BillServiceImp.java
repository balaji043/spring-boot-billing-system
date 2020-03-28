package com.bam.bs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bam.bs.entity.Bill;
import com.bam.bs.entity.BillRequest;
import com.bam.bs.exception.CommonException;
import com.bam.bs.repository.BillRepository;
import com.bam.bs.service.BillService;
import com.bam.bs.util.Message;
import com.bam.bs.util.Messages;

@Service
public class BillServiceImp implements BillService {

	private final BillRepository billRepository;

	@Autowired
	public BillServiceImp(BillRepository billRepository) {
		this.billRepository = billRepository;
	}

	@Override
	public Bill saveBill(Bill bill) {
		bill.getProducts().stream().forEach(e -> e.setBill(bill));
		billRepository.save(bill);
		if (bill.getId() != null)
			return bill;
		else
			throw new CommonException();
	}

	@Override
	public Bill updateBill(Bill bill) {
		bill.getProducts().stream().forEach(e -> e.setBill(bill));
		billRepository.save(bill);
		return bill;
	}

	@Override
	public List<Bill> searchBills(BillRequest billRequest) {
		return billRepository.findAll();
	}

	@Override
	public Message deleteBill(Long id) {
		billRepository.deleteById(id);
		return new Message(Messages.SUCCESS);
	}

}
