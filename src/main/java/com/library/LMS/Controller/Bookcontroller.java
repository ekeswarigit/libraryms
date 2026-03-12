package com.library.LMS.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.LMS.Dto.ApiResponse;
import com.library.LMS.Dto.BookRequest;
import com.library.LMS.Dto.BookResponse;
import com.library.LMS.Payload.Status;
import com.library.LMS.Service.BookService;

@RestController
@RequestMapping("/book")
public class Bookcontroller {
    
    @Autowired
    private BookService bookService;

    @PostMapping("/addbook")
    public ResponseEntity<ApiResponse<BookResponse>> addBook(@Validated @RequestBody BookRequest request) {

        BookResponse savedBook = bookService.addBook(request);

        ApiResponse<BookResponse> response = new ApiResponse<>( LocalDateTime.now(), Status.CREATED,200, null,
                "Book added successfully", savedBook);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> updateBook(@PathVariable Long id, @Validated @RequestBody BookRequest request) {

        BookResponse updatedBook = bookService.updateBook(id, request);

        ApiResponse<BookResponse> response = new ApiResponse<>(LocalDateTime.now(), Status.SUCCESS,200, null,
                "Book updated successfully", updatedBook);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);
        
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{author}")
    public ResponseEntity<ApiResponse<List<BookResponse>>> searchByAuthor(@PathVariable String author) {

        List<BookResponse> books = bookService.searchByAuthor(author);

        String message = books.isEmpty()
            ? "No books found for author: " + author
            : "Books fetched successfully";

        ApiResponse<List<BookResponse>> response = new ApiResponse<>(LocalDateTime.now(),Status.SUCCESS,200,null,
                message,books);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findall")
    public ResponseEntity<ApiResponse<Page<BookResponse>>> getAvailableBooks(
        @RequestParam(required = false) Long id,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10gi") int size) {

        Page<BookResponse> books = bookService.getAvailableBooks(id, page ,size);
        ApiResponse<Page<BookResponse>> response = new ApiResponse<>( LocalDateTime.now(), Status.SUCCESS,200, null,
                "Books fetched successfully", books);
        return ResponseEntity.ok(response);
    }
}

