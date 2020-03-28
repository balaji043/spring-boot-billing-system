package com.bam.bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bam.bs.entity.Bill;
import com.bam.bs.entity.BillRequest;
import com.bam.bs.service.BillService;
import com.bam.bs.util.Message;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/bam/bill")
public class BillController {

	@Autowired
	private BillService billService;

	@PostMapping("/save")
	public Bill saveBill(@RequestBody Bill bill) {
		return billService.saveBill(bill);
	}

	@PutMapping("/update")
	public Bill updateBill(@RequestBody Bill bill) {
		return billService.updateBill(bill);
	}

	@GetMapping("/search")
	public List<Bill> searchBills(@RequestBody BillRequest billRequest) {
		return billService.searchBills(billRequest);
	}

	@DeleteMapping("/delete/{id}")
	public Message deleteBill(@PathVariable("id") Long id) {
		return billService.deleteBill(id);
	}

}
