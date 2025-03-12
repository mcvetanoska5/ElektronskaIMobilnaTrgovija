package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Country;
import mk.ukim.finki.lab.model.dto.CountryDTO;
import java.util.List;
import java.util.Optional;

public interface CountryService {
    // Get all countries
    List<Country> findAll();
    // Save a new country (returns Optional<Country>)
    Optional<Country> save(CountryDTO countryDTO);
    // Find country by ID
    Optional<Country> findById(Long id);
    // Update an existing country
    Optional<Country> update(Long id, CountryDTO countryDTO);
    // Delete a country by ID
    void deleteById(Long id);
    // Find country by name
    Optional<Country> findByName(String countryName);
}
