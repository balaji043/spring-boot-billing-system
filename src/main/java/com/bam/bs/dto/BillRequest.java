package com.bam.bs.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import com.bam.bs.config.CustomDateDeSerializer;
import com.bam.bs.config.CustomDateSerializer;
import com.bam.bs.entity.Customer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;

@Getter
@Setter
@ApiModel
public class BillRequest {

    Boolean isAllBillRequest;

    @JsonDeserialize(using = CustomDateDeSerializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    Date startDate;

    @JsonDeserialize(using = CustomDateDeSerializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    Date endDate;

    Customer customer;

    String invoiceNumber;

}
