package com.bam.bs.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.bam.bs.util.BillType;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "BILL")
@Getter
@Setter
public class Bill implements Serializable {

    private static final long serialVersionUID = 8630090438139938349L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "INVOICE_NAME", unique = true)
    private String invoiceName;

    private LocalDate creationDate;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private Set<Product> products;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "BILL_TYPE")
    private BillType billType;

}
