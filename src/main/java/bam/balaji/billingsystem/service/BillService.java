package bam.balaji.billingsystem.service;


import bam.balaji.billingsystem.dto.BillDto;
import bam.balaji.billingsystem.entity.Bill;
import bam.balaji.billingsystem.entity.Customer;
import bam.balaji.billingsystem.util.BillType;
import bam.balaji.billingsystem.util.CustomerType;
import bam.balaji.billingsystem.util.Message;

import java.time.LocalDate;
import java.util.List;

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
