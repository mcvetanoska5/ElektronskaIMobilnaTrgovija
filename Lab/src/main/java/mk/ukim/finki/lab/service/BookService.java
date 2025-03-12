package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.dto.BookDTO;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> save(BookDTO bookDTO);
    Optional<Book> findById(Long id);
    Optional<Book> update(Long id, BookDTO bookDTO);
    void deleteById(Long id);

}
