package com.library.LMS.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.library.LMS.Entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

     List<Book> findByAuthorIgnoreCase(String author);

    List<Book> findByStatusIgnoreCase(String status);

    Optional<Book> findByTitle(String title);

   // List<Book> findByBookId(Long id);
      Page<Book> findByDeletedFalse(Pageable pageable);
      
      Optional<Book> findByBookIdAndDeletedFalse(Long id);

}
