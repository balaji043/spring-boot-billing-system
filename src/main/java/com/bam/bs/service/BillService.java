package com.bam.bs.service;

import java.util.List;

import com.bam.bs.dto.BillDto;
import com.bam.bs.entity.Bill;
import com.bam.bs.dto.BillRequest;
import com.bam.bs.util.Message;

public interface BillService {

	Bill saveBill(BillDto billDto);

	Bill updateBill(BillDto billDto);

	List<BillDto> searchBills(BillRequest billRequest);

	Message deleteBill(Long[] id);

}
