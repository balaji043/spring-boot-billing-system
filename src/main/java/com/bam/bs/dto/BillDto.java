package com.bam.bs.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import com.bam.bs.util.BillType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

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

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate creationDate;

    private BillType billType;

    private Set<ProductDto> products;

    private UserDto user;

    private CustomerDto customer;

}
