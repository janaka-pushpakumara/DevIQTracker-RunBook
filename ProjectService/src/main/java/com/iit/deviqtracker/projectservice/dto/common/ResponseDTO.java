package com.iit.deviqtracker.projectservice.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
	
	private Object data;
	private String message;
	private String status;
	private String errorCode;

}
