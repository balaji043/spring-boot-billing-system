package com.bam.bs.dto;

import java.time.LocalDate;
import java.util.Set;

import com.bam.bs.entity.Customer;
import com.bam.bs.entity.User;
import com.bam.bs.util.BillType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillDto {

    private Long id;

    private String invoiceName;

    private LocalDate creationDate;

    private BillType billType;

    private Set<ProductDto> products;

    private User user;

    private Customer customer;

}
