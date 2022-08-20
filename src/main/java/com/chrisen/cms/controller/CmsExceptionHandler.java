package com.chrisen.cms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.chrisen.cms.exception.CmsRecordNotFoundException;
import com.chrisen.cms.model.ApiResponse;

@ControllerAdvice
public class CmsExceptionHandler {
    
    @ExceptionHandler(CmsRecordNotFoundException.class)
    public ResponseEntity<ApiResponse> handleRecordNotFound() {
        final HttpStatus status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(
            new ApiResponse(
                status, 
                "No record/s found."), 
            status);
    }

}