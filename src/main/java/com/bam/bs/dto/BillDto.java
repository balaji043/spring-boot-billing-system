package com.bam.bs.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.bam.bs.config.CustomDateDeSerializer;
import com.bam.bs.config.CustomDateSerializer;
import com.bam.bs.util.BillType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillDto implements Serializable {

    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = -8635439789088132239L;

    private Long id;

    private String invoiceName;
    @JsonDeserialize(using = CustomDateDeSerializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date creationDate;

    private BillType billType;

    private Set<ProductDto> products;

    private UserDto user;

    private CustomerDto customer;

}
