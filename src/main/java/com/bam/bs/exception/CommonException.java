package com.bam.bs.exception;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = -5821789144577589829L;

	private final String code;

	public CommonException(String m, String code) {
		super(m);
		this.code = code;
	}
}
