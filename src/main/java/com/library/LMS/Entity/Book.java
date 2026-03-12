package com.library.LMS.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "books")
public class Book {

   // @SQLDelete(sql = "UPDATE books SET deleted = true WHERE book_id = ?")
   // @SQLRestriction("deleted = false")
  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT DEFAULT 0")
    private Long bookId;

    private String title;

    private String author;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isbn;

    private String status;

     @Column(columnDefinition = "INT DEFAULT 0")
     private Long count;
     @Column(nullable = false)
     private boolean deleted = false;
}
