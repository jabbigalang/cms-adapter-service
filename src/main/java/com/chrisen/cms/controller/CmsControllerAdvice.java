package com.chrisen.cms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.chrisen.cms.exception.CmsRecordNotFoundException;
import com.chrisen.cms.model.ApiResponse;

@ControllerAdvice
public class CmsControllerAdvice extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(CmsRecordNotFoundException.class)
    public ResponseEntity<ApiResponse> handleCmsRecordNotFoundException(CmsRecordNotFoundException ex) {
        return new ResponseEntity<>(
            new ApiResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null),
            HttpStatus.NOT_FOUND);
    }

}
