package com.bam.bs.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bam.bs.entity.Bill;
import com.bam.bs.entity.Customer;
import com.bam.bs.repository.BillRepository;
import com.bam.bs.service.BillService;
import com.bam.bs.util.BillType;
import com.bam.bs.util.CustomerType;
import com.bam.bs.util.Message;
import com.bam.bs.util.Messages;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillServiceImp implements BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillServiceImp(BillRepository billRepository) {
        this.billRepository = billRepository;
    }


    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public List<Bill> getAllBillsByBillType(BillType type) {
        return billRepository.findAllByBillType(type);
    }

    @Override
    public List<Bill> getAllBillsByBillTypeAndBetweenDatesWithCustomer(Customer customer, BillType billType, LocalDate startDate, LocalDate endDate) {
        return billRepository.findBillsByBillTypeAndCustomerAndCreationDateBetween(billType
                , customer
                , startDate
                , endDate
        );
    }

    @Override
    public List<Bill> getAllBillsByBillTypeAndWithCustomer(BillType type, Customer customer) {
        return billRepository.findBillsByBillTypeAndCustomer(type, customer);
    }

    @Override
    public List<Bill> getAllBillsByBillTypeAndWithSearchText(String searchString, BillType billType) {
        return billRepository.findAll();
    }

    @Override
    public List<Bill> getAllBillsByBillTypeAndBetweenDates(BillType billType, LocalDate startDate, LocalDate endDate) {
        return billRepository.findBillsByBillTypeAndCreationDateBetween(
                billType
                , startDate
                , endDate
        );
    }

    @Override
    public List<Bill> getAllBillsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return billRepository.findAllByCreationDateBetween(startDate
                , endDate);
    }

    @Override
    public List<Bill> getAllBillsByBillTypeAndCustomerType(BillType billType, CustomerType customerType) {
        return billRepository.findBillsByBillTypeAndCustomerCustomerType(
                billType,
                customerType
        );
    }

    @Override
    public Bill getBillByInvoiceName(String invoice) {
        return billRepository.findByInvoiceName(invoice);
    }

    @Override
    public Bill addNewBill(Bill bill) {
        bill.getProducts().stream().forEach(e->e.setBill(bill));
        billRepository.save(bill);
        if (bill.getId() != null)
            return bill;
        else
            throw new RuntimeException();
    }

    @Override
    public Bill updateBill(Bill bill) {
        bill.getProducts().stream().forEach(e->e.setBill(bill));
        billRepository.save(bill);
        return bill;
    }

    @Override
    public Message deleteBill(Bill bill) {
        billRepository.delete(bill);
        return new Message(Messages.SUCCESS);
    }

    @Override
    public Message deleteAllBill(List<Bill> bills) {
        billRepository.deleteAll(bills);
        return new Message(Messages.SUCCESS);
    }

}
