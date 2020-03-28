package com.bam.bs.service;

import java.util.List;

import com.bam.bs.entity.Bill;
import com.bam.bs.entity.BillRequest;
import com.bam.bs.util.Message;

public interface BillService {

	Bill saveBill(Bill billDto);

	Bill updateBill(Bill billDto);

	List<Bill> searchBills(BillRequest billRequest);

	Message deleteBill(Bill billDto);

}
