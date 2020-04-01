package com.bam.bs.dto;

import java.io.Serializable;

import com.bam.bs.util.CustomerType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto implements Serializable {

    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String city;

    private String gstNo;

    private String name;

    private String phoneNumber;

    private String street;

    private CustomerType customerType;

}
