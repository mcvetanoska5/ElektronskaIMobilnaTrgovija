package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.BookU;
import mk.ukim.finki.lab.model.dto.BookUDTO;
import mk.ukim.finki.lab.repository.BookURepository;
import mk.ukim.finki.lab.service.BookUService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookUServiceImpl implements BookUService {
    private final BookURepository bookURepository;
    public BookUServiceImpl(BookURepository bookURepository) {
        this.bookURepository = bookURepository;
    }
    @Override
    public List<BookU> findAll() {
        return this.bookURepository.findAll();
    }
    @Override
    public Optional<BookU> findById(Long id) {
        return this.bookURepository.findById(id);
    }
    @Override
    public Optional<BookU> save(BookUDTO bookUDTO) {
        if (bookUDTO.getUsername() != null) {
            return Optional.of(bookURepository.save(new BookU(
                    bookUDTO.getUsername()
            )));
        }
        return Optional.empty();
    }
    @Override
    public Optional<BookU> update(Long id, BookUDTO bookUDTO) {
        return bookURepository.findById(id).map(existingBook -> {
            if (bookUDTO.getUsername() != null) {
                existingBook.setUsername(bookUDTO.getUsername());
            }
            return bookURepository.save(existingBook);
        });
    }
}
