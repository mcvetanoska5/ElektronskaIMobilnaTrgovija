package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.BookU;
import mk.ukim.finki.lab.model.dto.BookDTO;
import mk.ukim.finki.lab.model.dto.BookUDTO;
import java.util.List;
import java.util.Optional;

public interface BookUService {

    List<BookU> findAll();
    Optional<BookU> findById(Long id);
    Optional<BookU> save(BookUDTO bookUDTO);
    Optional<BookU> update(Long id, BookUDTO bookUDTO);
}
