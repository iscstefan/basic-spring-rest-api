package com.example.bookstore.models.dto;

import com.example.bookstore.models.Bookstore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookstoreDTO {
    private Long id;
    @NotBlank
    private String name;

    public BookstoreDTO(Bookstore bookstore) {
        this.id = bookstore.getId();
        this.name = bookstore.getName();
    }
}
