package bam.balaji.billingsystem.entity;


import bam.balaji.billingsystem.util.BillType;
import bam.balaji.billingsystem.util.CustomerType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BillRequest {
    boolean allBillRequest;
    LocalDate startDate;
    LocalDate endDate;
    BillType billType;
    CustomerType customerType;
    Customer customer;
}
