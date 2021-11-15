package com.example.bookstore.models;

import com.example.bookstore.models.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @NotBlank()
    private String title;
    private int hardcover;
    private LocalDate publishDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="bookstore_id"
    )
    private Bookstore bookstore;

    public Book(BookDTO bookDTO) {
        this.title = bookDTO.getTitle();
        this.hardcover = bookDTO.getHardcover();
        this.publishDate = bookDTO.getPublishDate();
    }
}
