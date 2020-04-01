package com.bam.bs.controller;

import java.util.List;

import com.bam.bs.dto.BillDto;
import com.bam.bs.dto.BillRequest;
import com.bam.bs.entity.Bill;
import com.bam.bs.service.BillService;
import com.bam.bs.util.Message;
import com.bam.bs.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/bill")
public class BillController {

	@Autowired
	private BillService billService;

	@PostMapping
	@ApiOperation(value = "Save Bill")
	public Bill saveBill(@RequestBody BillDto bill) {
		return billService.saveBill(bill);
	}

	@PutMapping
	@ApiOperation(value= "Update Bill")
	public Bill updateBill(@RequestBody BillDto bill) {
		return billService.updateBill(bill);
	}

	@GetMapping
	@ApiOperation(value="Search Bills")
	public List<BillDto> searchBills(String billRequestString) {
		return billService.searchBills(Utils.readValue(billRequestString, BillRequest.class));
	}

	@DeleteMapping
	@ApiOperation(value= "Delete Bill")
	public Message deleteBill(@RequestParam("ids[]") Long[] ids) {
		return billService.deleteBill(ids);
	}

}
