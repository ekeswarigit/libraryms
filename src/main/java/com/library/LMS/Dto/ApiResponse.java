package com.library.LMS.Dto;

import java.time.LocalDateTime;

import com.library.LMS.Payload.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private LocalDateTime timestamp;
    private Status status;
    private int code;
    private String error;
    private String message;
    private T data;


    // public ApiResponse(LocalDateTime timestamp, Status status,int code, String error, String message, T data) {
    //     this.timestamp = timestamp;
    //     this.status = status;
    //     this.code = status.getCode();
    //     this.error = error;
    //     this.message = message;
    //     this.data = data;
    // }

}    