package com.qbo.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorMessage {
	
	private Integer statusCode;
	private Date timestamp;
	private String message;
	private String description;

}
