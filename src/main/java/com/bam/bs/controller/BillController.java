package com.bam.bs.controller;

import java.util.List;

import javax.validation.Valid;

import com.bam.bs.dto.BillDto;
import com.bam.bs.dto.BillRequest;
import com.bam.bs.entity.Bill;
import com.bam.bs.service.BillService;
import com.bam.bs.util.Message;
import com.bam.bs.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/bill")
public class BillController {

	@Autowired
	private BillService billService;

	@Autowired
	@Qualifier("SaveBillRequestValidator")
	private Validator saveBillRequestValidator;

	@InitBinder
	private void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(saveBillRequestValidator);
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")
	@ApiOperation(value = "Save Bill")
	public Bill saveBill(@Valid @RequestBody BillDto bill, BindingResult bindingResult, Model model) {
		return billService.saveBill(bill);
	}

	@PutMapping
	@PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")

	@ApiOperation(value = "Update Bill")
	public Bill updateBill(@RequestBody BillDto bill) {
		return billService.updateBill(bill);
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")
	@ApiOperation(value = "Search Bills")
	public List<BillDto> searchBills(String billRequestString) {
		return billService.searchBills(Utils.readValue(billRequestString, BillRequest.class));
	}

	@DeleteMapping
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "Delete Bill")
	public Message deleteBill(@RequestParam("ids[]") Long[] ids) {
		return billService.deleteBill(ids);
	}

}
