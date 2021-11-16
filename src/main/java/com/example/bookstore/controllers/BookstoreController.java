package com.example.bookstore.controllers;

import com.example.bookstore.models.Bookstore;
import com.example.bookstore.models.dto.BookstoreDTO;
import com.example.bookstore.services.BookstoreService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public BookstoreDTO add(@RequestBody @Valid BookstoreDTO bookstoreDTO) {
        return bookstoreService.add(bookstoreDTO);
    }

    @DeleteMapping("{id}")
    public BookstoreDTO delete(@PathVariable Long id) {
        return bookstoreService.delete(id);
    }

    @PutMapping("{id}")
    public BookstoreDTO update(@PathVariable Long id, @RequestBody @Valid BookstoreDTO bookstoreDTO) {
        return bookstoreService.update(id,bookstoreDTO);
    }

}
