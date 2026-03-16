package com.library.LMS.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.library.LMS.Dto.ApiResponse;
import com.library.LMS.Payload.Status;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Object>> handleRuntimeException(RuntimeException ex) {

        ApiResponse<Object> response = new ApiResponse<>(LocalDateTime.now(),Status.NO_CONTENT,204, ex.getMessage(),  "Something went wrong",null);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
