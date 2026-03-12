package com.library.LMS.Dto;
  
import lombok.Data;

@Data
public class BookResponse {

    private Long bookId;
    private String title;
    private String author;
    private String status;
    private Long count;
    
}
