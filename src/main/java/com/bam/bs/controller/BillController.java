package com.bam.bs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bam.bs.dto.BillDto;
import com.bam.bs.entity.Bill;
import com.bam.bs.entity.BillRequest;
import com.bam.bs.service.BillService;
import com.bam.bs.util.Message;

import java.util.ArrayList;
import java.util.List;

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
    public List<Bill> getAllBillsByBillType(@RequestBody BillRequest billRequest) {
        return service.getAllBillsByBillType(billRequest.getBillType());
    }

    @GetMapping("/getAllBillsByBillTypeAndBetweenDatesWithCustomer")
    public List<Bill> getAllBillsByBillTypeAndBetweenDatesWithCustomer(@RequestBody BillRequest billRequest) {
        return service.getAllBillsByBillTypeAndBetweenDatesWithCustomer(billRequest.getCustomer(), billRequest.getBillType(), billRequest.getStartDate(), billRequest.getEndDate());
    }

    @GetMapping("/getAllBillsByBillTypeAndWithCustomer")
    public List<Bill> getAllBillsByBillTypeAndWithCustomer(@RequestBody BillRequest billRequest) {
        return service.getAllBillsByBillTypeAndWithCustomer(billRequest.getBillType(), billRequest.getCustomer());
    }

    @GetMapping("/getAllBillsByBillTypeAndWithSearchText")
    public List<BillDto> getAllBillsByBillTypeAndWithSearchText(@RequestBody BillRequest billRequest) {
        //TODO: Have to do
        return new ArrayList<>();
    }

    @GetMapping("/getAllBillsByBillTypeAndBetweenDates")
    public List<BillDto> getAllBillsByBillTypeAndBetweenDates(@RequestBody BillRequest billRequest) {
        return null;
    }

    @GetMapping("/getAllBillsBetweenDates")
    public BillDto[] getAllBillsBetweenDates(@RequestBody BillRequest billRequest) {
        return null;
    }

    @GetMapping("/getAllBillsByBillTypeAndCustomerType")
    public List<BillDto> getAllBillsByBillTypeAndCustomerType(@RequestBody BillRequest billRequest) {
        return null;
    }

    @GetMapping("/getBillByInvoiceName")
    public BillDto getBillByInvoiceName(String invoice) {
        return null;
    }

    @PostMapping("/save")
    public Bill addNewBill(@RequestBody Bill bill) {
        return service.addNewBill(bill);
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
