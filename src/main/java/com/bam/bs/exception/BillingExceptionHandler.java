package com.bam.bs.exception;

import com.bam.bs.dto.ApiResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class BillingExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CommonException.class)
	public ApiResponse<String> handleCommonException(CommonException ex) {
		return new ApiResponse<>(ex.getMessage(), ex.getCode(), "Failure");
	}

	@ExceptionHandler(Exception.class)
	public ApiResponse<String> handleException(Exception ex) {
		log.error("{}", ex);
		return new ApiResponse<>(ex.getMessage(), "INTERNAL_SERVER_ERROR", "Failure");
	}
}
