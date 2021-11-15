package com.example.bookstore.services;

import com.example.bookstore.models.Book;
import com.example.bookstore.models.dto.BookDTO;
import com.example.bookstore.models.Bookstore;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.BookstoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookstoreRepository bookstoreRepository;
    private final BookRepository bookRepository;

    public BookService(BookstoreRepository bookstoreRepository, BookRepository bookRepository) {
        this.bookstoreRepository = bookstoreRepository;
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAll(Long storeId) {
        var bookstore = getBookstoreById(storeId);

        return bookstore
                .getBooks()
                .stream().map(BookDTO::new)
                .collect(Collectors.toList());
    }

    public BookDTO add(Long storeId, BookDTO bookDTO) {
        var bookstore = getBookstoreById(storeId);

        var book = new Book(bookDTO);
        book.setBookstore(bookstore);
        book = bookRepository.save(book);

        return new BookDTO(book);
    }

    public BookDTO delete(Long storeId, Long bookId) {
        getBookstoreById(storeId);
        var book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        bookRepository.delete(book);

        return new BookDTO(book);
    }

    public Bookstore getBookstoreById(Long storeId) {
        return bookstoreRepository
                .findById(storeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
