package com.bam.bs.service;


import java.time.LocalDate;
import java.util.List;

import com.bam.bs.dto.BillDto;
import com.bam.bs.entity.Bill;
import com.bam.bs.entity.Customer;
import com.bam.bs.util.BillType;
import com.bam.bs.util.CustomerType;
import com.bam.bs.util.Message;

public interface BillService {

    List<Bill> getAllBills();

    List<Bill> getAllBillsByBillType(BillType type);

    List<Bill> getAllBillsByBillTypeAndBetweenDatesWithCustomer(Customer customer
            , BillType billType
            , LocalDate startDate
            , LocalDate endDate);

    List<Bill> getAllBillsByBillTypeAndWithCustomer(BillType type, Customer customer);

    List<Bill> getAllBillsByBillTypeAndWithSearchText(String searchString, BillType billType);

    List<Bill> getAllBillsByBillTypeAndBetweenDates(BillType billType
            , LocalDate startDate
            , LocalDate endDate);

    List<Bill> getAllBillsBetweenDates(LocalDate startDate, LocalDate endDate);

    List<Bill> getAllBillsByBillTypeAndCustomerType(BillType billType, CustomerType customerType);

    Bill getBillByInvoiceName(String invoice);

    Bill addNewBill(Bill billDto);

    Bill updateBill(Bill billDto);

    Message deleteBill(Bill billDto);

    Message deleteAllBill(List<Bill> billDtos);
}
