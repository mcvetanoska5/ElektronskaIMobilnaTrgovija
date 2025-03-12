package mk.ukim.finki.lab.web;

import mk.ukim.finki.lab.model.Country;
import mk.ukim.finki.lab.model.dto.CountryDTO;
import mk.ukim.finki.lab.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/librarian/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    // Get all countries
    @GetMapping
    public List<Country> findAll() {
        return countryService.findAll();
    }
    // Get country by ID
    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        return countryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // Create new country
    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestBody CountryDTO countryDTO) {
        return countryService.save(countryDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    // Update book
    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> update(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
        return countryService.update(id, countryDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Delete country
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (countryService.findById(id).isPresent()) {
            countryService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
