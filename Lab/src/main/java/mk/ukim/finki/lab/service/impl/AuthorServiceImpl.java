package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.dto.AuthorDTO;
import mk.ukim.finki.lab.repository.AuthorRepository;
import mk.ukim.finki.lab.service.AuthorService;
import mk.ukim.finki.lab.service.CountryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryService countryService;
    public AuthorServiceImpl(AuthorRepository authorRepository, CountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
    }
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
    @Override
    public Optional<Author> save(AuthorDTO authorDTO) {
        if (authorDTO.getCountryName() != null && countryService.findByName(authorDTO.getCountryName()).isPresent()) {
            return Optional.of(
                    authorRepository.save(new Author(authorDTO.getName(), authorDTO.getSurname(),
                            countryService.findByName(authorDTO.getCountryName()).get())));
        }
        return Optional.empty();
    }
    @Override
    public Optional<Author> update(Long id, AuthorDTO authorDTO) {
        return authorRepository.findById(id).map(existingAuthor -> {
            if (authorDTO.getName() != null) {
                existingAuthor.setName(authorDTO.getName());
            }
            if (authorDTO.getSurname() != null) {
                existingAuthor.setSurname(authorDTO.getSurname());
            }
            if (authorDTO.getCountryName() != null && countryService.findByName(authorDTO.getCountryName()).isPresent()) {
                existingAuthor.setCountry(countryService.findByName(authorDTO.getCountryName()).get());
            }
            return authorRepository.save(existingAuthor);
        });
    }
    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
    @Override
    public Optional<Author> findByName(String authorName) {
        return authorRepository.findByName(authorName);
    }
}