package com.bam.bs.dto;

import java.io.Serializable;
import java.util.Date;

import com.bam.bs.config.CustomDateDeSerializer;
import com.bam.bs.config.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
    @JsonDeserialize(using = CustomDateDeSerializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date date;
    private String invoiceAmount;
    private String userName;

}