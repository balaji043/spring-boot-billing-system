package com.bam.bs.entity;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import com.bam.bs.util.BillType;
import com.bam.bs.util.CustomerType;

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
