package com.bam.bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    private final BillService service;

    @Autowired
    public BillController(BillService service) {
        this.service = service;
    }


    @GetMapping("/all")
    public List<Bill> getAllBills() {
        return service.getAllBills();
    }

    @GetMapping("/getAllBillsByBillType")
    public List<Bill> searchBills(@RequestBody BillRequest billRequest) {
        return service.searchBills(billRequest.getBillType());
    }


    @PostMapping("/save")
    public Bill addNewBill(@RequestBody Bill bill) {
        return service.saveBill(bill);
    }

    @PutMapping("/update")
    public Bill updateBill(@RequestBody Bill bill) {
        return service.updateBill(bill);
    }

    @DeleteMapping("/delete")
    public Message deleteBill(@RequestBody Bill bill) {
        return service.deleteBill(bill);
    }

    @DeleteMapping("/delete/all")
    public Message deleteAllBill(@RequestBody List<Bill> bills) {
        return service.deleteAllBill(bills);
    }

}
