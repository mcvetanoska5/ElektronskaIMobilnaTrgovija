package mk.ukim.finki.lab.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.lab.model.enumerations.CategoryEnum;
import mk.ukim.finki.lab.model.enumerations.CategoryEnum;

@Entity
@Data
@Table(name = "book")
public class Book {
    public Book() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    @ManyToOne
    private Author author;
    private Integer availableCopies;
    public Book(String name, CategoryEnum category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}