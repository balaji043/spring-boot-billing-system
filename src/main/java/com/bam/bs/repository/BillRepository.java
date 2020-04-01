package com.bam.bs.repository;

import java.time.LocalDate;
import java.util.List;

import com.bam.bs.entity.Bill;
import com.bam.bs.util.BillType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

        List<Bill> findAllByBillType(BillType billType);

        // List<Bill> findBillsByBillType

        List<Bill> findBillsByBillTypeAndCreationDateBetween(BillType type, LocalDate startDate, LocalDate endDate);

        List<Bill> findAllByCreationDateBetween(LocalDate startDate, LocalDate endDate);

        Bill findByInvoiceName(String invoiceName);

        void deleteAllById(Long[] id);

}
