package com.bam.bs.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import com.bam.bs.entity.Customer;
import com.bam.bs.util.BillType;
import com.bam.bs.util.CustomerType;

import io.swagger.annotations.ApiModel;

@Getter
@Setter
@ApiModel
public class BillRequest {
    Boolean isAllBillRequest;
    LocalDate startDate;
    LocalDate endDate;
    BillType billType;
    Long customerId;
    Long userId;
    CustomerType customerType;
    Customer customer;
}
