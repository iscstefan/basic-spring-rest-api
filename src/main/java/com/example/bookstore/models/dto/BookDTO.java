package com.example.bookstore.models.dto;

import com.example.bookstore.models.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    @NotBlank()
    private String title;
    private int hardcover;
    private LocalDate publishDate;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.hardcover = book.getHardcover();
        this.publishDate = book.getPublishDate();
    }
}
