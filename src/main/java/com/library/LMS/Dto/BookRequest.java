package com.library.LMS.Dto;

import lombok.Data;

@Data
public class BookRequest {
    
    
    private String title;
    private String author;
    private Long count;
}

