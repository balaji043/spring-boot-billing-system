package com.bam.bs.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * SearchBillResponse
 */
@Getter
@Setter
@NoArgsConstructor
public class SearchBillResponse implements Serializable {

    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = 8738959121083602890L;

    private Long id;
    private String customerName;
    private String place;
    private String invoice;
    private LocalDate date;
    private String invoiceAmount;
    private String userName;

}