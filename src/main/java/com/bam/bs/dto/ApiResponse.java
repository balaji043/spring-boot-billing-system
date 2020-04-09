package com.bam.bs.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

    private String code;
    private String message;
    private T data;

    public ApiResponse(T data, String code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

}