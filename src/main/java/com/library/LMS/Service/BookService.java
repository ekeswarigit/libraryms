package com.library.LMS.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.library.LMS.Dto.BookRequest;
import com.library.LMS.Dto.BookResponse;


@Service
public interface BookService {

    BookResponse addBook(BookRequest books);

    BookResponse updateBook(Long id, BookRequest books);

    void deleteBook(Long id);

    List<BookResponse> searchByAuthor(String author);

    Page<BookResponse> getAvailableBooks(Long id, int page, int size);
}
