package com.library.LMS.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.library.LMS.Dto.BookRequest;
import com.library.LMS.Dto.BookResponse;
import com.library.LMS.Entity.Book;
import com.library.LMS.Exception.ResourceNotFoundException;
import com.library.LMS.Repository.BookRepo;
import com.library.LMS.Util.BookMapper;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepo bookRepository;


    public BookResponse addBook(BookRequest request) {

        // Convert DTO → Entity
        Book book = BookMapper.toEntity(request);

        Optional<Book> existingBook = bookRepository.findByTitle(book.getTitle());

        if (existingBook.isPresent()) {

            Book bookFromDb = existingBook.get();
            bookFromDb.setCount(bookFromDb.getCount() + book.getCount());
            Book savedBook = bookRepository.save(bookFromDb);

            // Convert Entity → Response DTO
            return BookMapper.toResponse(savedBook);

        } else {
            if (book.getCount() == null || book.getCount() <= 0) {
                book.setCount(1L);
            }

            Book savedBook = bookRepository.save(book);
            return BookMapper.toResponse(savedBook);
        }
    }

    @Override
    public BookResponse updateBook(Long id, BookRequest updatedBook) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        // Use mapper to update fields
        BookMapper.updateEntity(existingBook, updatedBook);

        Book savedBook = bookRepository.save(existingBook);
        return BookMapper.toResponse(savedBook);
    }

    
    @Override
    public void deleteBook(Long id) {

        // if (!bookRepository.existsById(id)) {
        //     throw new RuntimeException("Book not found with id: " + id);
        // }

        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        book.setDeleted(true);   // ✅ mark as deleted
        bookRepository.save(book);
        book.setDeleted(true);   // ✅ mark as deleted
        bookRepository.save(book);
        //return "Book deleted successfully";
    }

    @Override
    public List<BookResponse> searchByAuthor(String author) {

        return bookRepository.findByAuthorIgnoreCase(author)
                .stream()
                .map(BookMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Page<BookResponse> getAvailableBooks(Long id, int page, int size) {

    //List<Book> books;
     Pageable pageable = PageRequest.of(page, size);
    if (id == null) {
        return bookRepository.findByDeletedFalse(pageable)
        .map(BookMapper::toResponse);
    } else {
        Book book = bookRepository.findByBookIdAndDeletedFalse(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        return new PageImpl<>(
                List.of(BookMapper.toResponse(book)),
                pageable,
                1
        );
    }
       
    }
}