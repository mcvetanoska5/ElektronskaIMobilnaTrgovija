package mk.ukim.finki.lab.model.dto;

import lombok.Data;

@Data
public class CountryDTO {
    private Long id;
    private String name;
    private String continent;
    // Constructors
    public CountryDTO(Long id, String name, String continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
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
    public String getContinent() {
        return continent;
    }
    public void setContinent(String continent) {
        this.continent = continent;
    }
}
