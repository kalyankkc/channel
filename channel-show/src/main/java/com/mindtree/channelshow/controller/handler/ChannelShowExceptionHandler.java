package com.mindtree.channelshow.controller.handler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.channelshow.controller.ChannelShowAppController;
import com.mindtree.channelshow.exception.ChannelShowServiceException;

@RestControllerAdvice(assignableTypes = ChannelShowAppController.class)
public class ChannelShowExceptionHandler 
{
		@ExceptionHandler(ChannelShowServiceException.class)
		public ResponseEntity<Map<String, Object>> ServiceExceptionHandler(Exception e, Throwable cause)
		{
			Map<String, Object> response = new LinkedHashMap<>();
			response.put("header", "Error Occured");
			response.put("ERROR", true);
			response.put("body", e.getMessage());
			response.put("HTTP STATUS", HttpStatus.BAD_REQUEST );
			 
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST );	 
		}
}
