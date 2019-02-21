package com.api.webapp.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ResponseBody
    @ExceptionHandler({ValidationException.class})
    public ResponseEntity handleException(ValidationException e) {
        return  ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiError(e.getMessage()));
    }
}