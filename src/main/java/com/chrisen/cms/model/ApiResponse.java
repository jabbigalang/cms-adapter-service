package com.chrisen.cms.model;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private int code;
    private String status;
    private String message;
    private Object data;

    public ApiResponse(HttpStatus httpStatus, String message) {
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

    public ApiResponse(HttpStatus httpStatus, String message, Object data) {
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
        this.data = data;
    }
}
