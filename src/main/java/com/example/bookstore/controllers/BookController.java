package com.example.bookstore.controllers;

import com.example.bookstore.models.dto.BookDTO;
import com.example.bookstore.services.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bookstore/{storeId}/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<BookDTO> getAll(@PathVariable Long storeId) {
        return bookService.getAll(storeId);
    }

    @PostMapping()
    public BookDTO add(@PathVariable Long storeId, @RequestBody @Valid BookDTO bookDTO) {
        return bookService.add(storeId, bookDTO);
    }

    @DeleteMapping("{bookId}")
    public BookDTO delete(@PathVariable Long storeId, @PathVariable Long bookId) {
        return bookService.delete(storeId, bookId);
    }
}
