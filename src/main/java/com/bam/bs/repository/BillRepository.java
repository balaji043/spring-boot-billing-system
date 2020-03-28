package com.bam.bs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bam.bs.entity.Bill;
import com.bam.bs.entity.Customer;
import com.bam.bs.util.BillType;
import com.bam.bs.util.CustomerType;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    List<Bill> findAllByBillType(BillType billType);

    List<Bill> findBillsByBillTypeAndCustomerAndCreationDateBetween(
            BillType billType
            , Customer customer
            , LocalDate startDate
            , LocalDate endDate
    );

    List<Bill> findBillsByBillTypeAndCustomer(BillType type, Customer customer);

//    List<Bill> findBillsByBillType

    List<Bill> findBillsByBillTypeAndCreationDateBetween(
            BillType type
            , LocalDate startDate
            , LocalDate endDate
    );

    List<Bill> findAllByCreationDateBetween(LocalDate startDate
            , LocalDate endDate);

    List<Bill> findBillsByBillTypeAndCustomerCustomerType(
            BillType billType
            , CustomerType customerType
    );

    Bill findByInvoiceName(String invoiceName);

}
