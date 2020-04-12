package com.bam.bs.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.bam.bs.util.BillType;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@NamedEntityGraph(name = "graph.Bill",
    attributeNodes = {
        @NamedAttributeNode(value = "id"),
        @NamedAttributeNode(value = "invoiceName"),
        @NamedAttributeNode(value = "creationDate"),
        @NamedAttributeNode(value = "products", subgraph = "subGraph.Product"),
        @NamedAttributeNode(value = "customer", subgraph = "subGraph.Customer"),
        @NamedAttributeNode(value = "user", subgraph = "subGraph.User")
    },
    subgraphs = {
        @NamedSubgraph(
            name = "subGraph.Product",
            attributeNodes = {
                @NamedAttributeNode(value = "quantity"),
                @NamedAttributeNode(value = "taxPercentage"),
                @NamedAttributeNode(value = "rate")
            }
        ),
        @NamedSubgraph(
            name = "subGraph.Customer",
            attributeNodes = {
                @NamedAttributeNode(value = "name")
            }
        ),
        @NamedSubgraph(
            name = "subGraph.User",
            attributeNodes = {
                @NamedAttributeNode(value = "name")
            }
        )
    }
)
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

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private Set<Product> products;

    @ManyToOne
    private User user;

    @ManyToOne
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "BILL_TYPE")
    private BillType billType;

}
