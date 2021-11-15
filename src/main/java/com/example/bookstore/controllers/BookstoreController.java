package com.example.bookstore.controllers;

import com.example.bookstore.models.dto.BookstoreDTO;
import com.example.bookstore.services.BookstoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "bookstore")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping
    public List<BookstoreDTO> getAll() {
        return bookstoreService.getAll();
    }

    @PostMapping
    public BookstoreDTO add(@RequestBody BookstoreDTO bookstoreDTO) {
        return bookstoreService.add(bookstoreDTO);
    }

    @DeleteMapping("{id}")
    public BookstoreDTO delete(@PathVariable String id) {
        return bookstoreService.delete(id);
    }
}
