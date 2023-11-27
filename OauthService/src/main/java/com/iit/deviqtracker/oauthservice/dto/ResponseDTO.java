package com.iit.deviqtracker.oauthservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
	
	private Object data;
	private String message;
	private int status;
	private String errorCode;

}
