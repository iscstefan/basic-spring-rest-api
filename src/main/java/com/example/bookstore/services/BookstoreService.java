package com.example.bookstore.services;

import com.example.bookstore.models.Bookstore;
import com.example.bookstore.models.dto.BookstoreDTO;
import com.example.bookstore.repository.BookstoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookstoreService {
    private final BookstoreRepository bookstoreRepository;

    public BookstoreService(BookstoreRepository bookstoreRepository) {
        this.bookstoreRepository = bookstoreRepository;
    }

    public List<BookstoreDTO> getAll() {
        return bookstoreRepository
                .findAll()
                .stream()
                .map(BookstoreDTO::new)
                .collect(Collectors.toList());
    }

    public BookstoreDTO add(BookstoreDTO bookstoreDTO) {
        var bookstore = bookstoreRepository.save(Bookstore.builder().name(bookstoreDTO.getName()).build());
        return new BookstoreDTO(bookstore);
    }

    public BookstoreDTO delete(Long id) {
        var bookstore = bookstoreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        bookstoreRepository.delete(bookstore);
        return new BookstoreDTO(bookstore);
    }

    public BookstoreDTO update(Long id, BookstoreDTO bookstoreDTO) {
        var bookstore = bookstoreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        bookstore.setName(bookstoreDTO.getName());
        bookstore = bookstoreRepository.save(bookstore);
        return new BookstoreDTO(bookstore);
    }
}
