package bam.balaji.billingsystem.repository;

import bam.balaji.billingsystem.entity.Bill;
import bam.balaji.billingsystem.entity.Customer;
import bam.balaji.billingsystem.util.BillType;
import bam.balaji.billingsystem.util.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
