package bam.balaji.billingsystem.dto;

import bam.balaji.billingsystem.entity.Customer;
import bam.balaji.billingsystem.entity.Product;
import bam.balaji.billingsystem.entity.User;
import bam.balaji.billingsystem.util.BillType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class BillDto {

    private Long id;

    private String invoiceName;

    private LocalDate creationDate;

    private BillType billType;

    private Set<ProductDto> products;

    private User user;

    private Customer customer;

}
