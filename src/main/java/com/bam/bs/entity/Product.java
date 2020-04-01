package com.bam.bs.entity;

import com.bam.bs.util.PerValue;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Product")
@Getter
@Setter
@ToString
public class Product implements Serializable {

    private static final long serialVersionUID = -6548945007368293623L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "HSN_CODE", nullable = false)
    private String hsnCode;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "TAX_PERCENTAGE", nullable = false)
    private Integer taxPercentage;

    @Column(name = "RATE", nullable = false)
    private Double rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "PER_VALUE")
    private PerValue perValue;

    @ManyToOne(optional = false, targetEntity = Bill.class)
    @JsonIgnore
    private Bill bill;

}
