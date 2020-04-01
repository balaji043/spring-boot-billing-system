package com.bam.bs.dto;

import java.io.Serializable;

import com.bam.bs.util.CustomerType;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class CustomerRequest implements Serializable {
    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = 5539026824991785458L;
    Boolean isAllCustomerRequest;
    CustomerType customerType;

}
