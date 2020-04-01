package com.bam.bs.dto;

import java.io.Serializable;

import com.bam.bs.util.PerValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto implements Serializable {

    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = 8132841520653134989L;

    private Long id;

    private String description
    ;

    private String hsnCode;

    private Integer quantity;

    private Integer taxPercentage;

    private Double rate;

    private PerValue perValue;

}
