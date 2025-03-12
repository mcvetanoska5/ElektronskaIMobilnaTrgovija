package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.dto.BookDTO;
import mk.ukim.finki.lab.repository.BookRepository;
import mk.ukim.finki.lab.service.AuthorService;
import mk.ukim.finki.lab.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDTO bookDTO) {
        if (bookDTO.getName() != null &&
                bookDTO.getCategory() != null &&
                bookDTO.getAuthorName() != null) {

            return Optional.of(bookRepository.save(new Book(
                    bookDTO.getName(),
                    bookDTO.getCategory(),
                    authorService.findByName(bookDTO.getAuthorName()).orElse(null),
                    bookDTO.getAvailableCopies()
            )));
        }
        return Optional.empty();
    }
    @Override
    public Optional<Book> update(Long id, BookDTO bookDTO) {
        return bookRepository.findById(id).map(existingBook -> {
            if (bookDTO.getName() != null) {
                existingBook.setName(bookDTO.getName());
            }
            if (bookDTO.getCategory() != null) {
                existingBook.setCategory(bookDTO.getCategory());
            }
            if (bookDTO.getAuthorName() != null) {
                existingBook.setAuthor(authorService.findByName(bookDTO.getAuthorName()).orElse(null));
            }
            if (bookDTO.getAvailableCopies() != null) {
                existingBook.setAvailableCopies(bookDTO.getAvailableCopies());
            }
            return bookRepository.save(existingBook);
        });
    }
    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
