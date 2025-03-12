package mk.ukim.finki.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.lab.model.enumerations.CategoryEnum;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    @ManyToOne
    private Author author;
    private Integer availableCopies;

    public Book(String name, CategoryEnum category, Author author, Integer availableCopies)  {
        this.name=name;
        this.category=category;
        this.author=author;
        this.availableCopies=availableCopies;
    }
    public Book(Long id, String name, CategoryEnum category, Author author, Integer availableCopies) {
      this.id=id;
      this.name=name;
      this.category=category;
      this.author=author;
      this.availableCopies=availableCopies;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public CategoryEnum getCategory() {
        return category;
    }
    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public Integer getAvailableCopies() {
        return availableCopies;
    }
    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }
}

