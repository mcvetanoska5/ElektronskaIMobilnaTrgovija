package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Country;
import mk.ukim.finki.lab.model.dto.CountryDTO;
import mk.ukim.finki.lab.repository.CountryRepository;
import mk.ukim.finki.lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> save(CountryDTO countryDTO) {
        // You can add additional validation here if needed
        Country country = new Country(countryDTO.getName(), countryDTO.getContinent());
        Country savedCountry = countryRepository.save(country);
        return Optional.of(savedCountry);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> update(Long id, CountryDTO countryDTO) {
        // Find the existing country first
        Optional<Country> existingCountry = countryRepository.findById(id);
        if (existingCountry.isPresent()) {
            Country country = existingCountry.get();
            country.setName(countryDTO.getName());
            country.setContinent(countryDTO.getContinent());
            countryRepository.save(country);
            return Optional.of(country);
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Optional<Country> findByName(String countryName) {
        return countryRepository.findByName(countryName);
    }
}
