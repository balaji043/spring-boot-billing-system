package com.bam.bs.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import com.bam.bs.util.CustomerType;

import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
@ToString
public class Customer implements Serializable {

    private static final long serialVersionUID = 3719750814154703990L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",unique = true,nullable = false)
    private Long id;

    @Column(name = "CITY")
    private String city;

    @Column(name = "GST_NO",unique = true,length = 15)
    @Pattern(regexp = "^[0-9]{15}$")
    private String gstNo;

    @Column(name = "NAME",unique = true,nullable = false)
    private String name;

    @Column(name = "PHONE_NUMBER",unique = true,length = 10)
    @Pattern(regexp = "^[0-9]{10}$")
    private String phoneNumber;

    @Column(name = "STREET")
    private String street;

    @Enumerated(EnumType.STRING)
    @Column(name = "CUSTOMER_TYPE")
    private CustomerType customerType;


}