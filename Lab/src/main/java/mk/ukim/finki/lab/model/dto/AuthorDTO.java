package mk.ukim.finki.lab.model.dto;

import lombok.Data;

@Data
public class AuthorDTO {
    private Long id;
    private String name;
    private String surname;
    private String countryName;
    // Constructors
    public AuthorDTO(Long id, String name, String surname, String countryName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.countryName = countryName;
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
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
