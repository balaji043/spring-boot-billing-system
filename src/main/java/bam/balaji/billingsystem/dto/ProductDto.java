package bam.balaji.billingsystem.dto;

import bam.balaji.billingsystem.util.PerValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;

    private String name;

    private String hsnCode;

    private Integer quantity;

    private Integer taxPercentage;

    private Double rate;

    private PerValue perValue;

}
