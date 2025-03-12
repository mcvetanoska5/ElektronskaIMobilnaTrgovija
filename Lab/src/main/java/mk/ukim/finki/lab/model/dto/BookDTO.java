package mk.ukim.finki.lab.model.dto;

import lombok.Data;
import mk.ukim.finki.lab.model.enumerations.CategoryEnum;

@Data
public class BookDTO {
    private Long id;
    private String name;
    private CategoryEnum category;
    private String authorName;
    private Integer availableCopies;
    // Constructors
    public BookDTO(Long id, String name, CategoryEnum category, String authorName, Integer availableCopies) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.authorName = authorName;
        this.availableCopies = availableCopies;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public Integer getAvailableCopies() {
        return availableCopies;
    }
    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }
}
