package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.dto.AuthorDTO;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> save(AuthorDTO authorDTO);
    Optional<Author> findById(Long id);
    Optional<Author> update(Long id, AuthorDTO authorDTO);
    void deleteById(Long id);
    Optional<Author> findByName(String authorName);
}
