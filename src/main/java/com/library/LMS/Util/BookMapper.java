package com.library.LMS.Util;

import com.library.LMS.Dto.BookRequest;
import com.library.LMS.Dto.BookResponse;
import com.library.LMS.Entity.Book;
import lombok.Builder;

@Builder
public class BookMapper {

    //  Convert Request DTO → Entity
    public static Book toEntity(BookRequest request) {
        if (request == null) return null;

        return Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .count(request.getCount() != null ? request.getCount() : 1L)
                .status("AVAILABLE")
                .isbn(false)
                .build();
    }

    //  Convert Entity → Response DTO
    public static BookResponse toResponse(Book book) {
        if (book == null) return null;

        BookResponse response = new BookResponse();
        response.setBookId(book.getBookId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setStatus(book.getStatus());
        response.setCount(book.getCount());
        return response;
    }

    //  Update Entity from Request (for PUT API)
    public static void updateEntity(Book book, BookRequest request) {
        if (book == null || request == null) return;

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());

        if (request.getCount() != null) {
            book.setCount(request.getCount());
        }
    }

}
