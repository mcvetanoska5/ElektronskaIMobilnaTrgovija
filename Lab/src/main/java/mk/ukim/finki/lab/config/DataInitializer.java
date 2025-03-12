package mk.ukim.finki.lab.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.enumerations.CategoryEnum;
import mk.ukim.finki.lab.model.Country;
import mk.ukim.finki.lab.repository.AuthorRepository;
import mk.ukim.finki.lab.repository.BookRepository;
import mk.ukim.finki.lab.repository.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(CountryRepository countryRepository,
                           AuthorRepository authorRepository,
                           BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    @PostConstruct
    public void initData() {
        Country macedonia = new Country("North Macedonia", "Europe");
        Country usa = new Country("USA", "North America");
        countryRepository.save(macedonia);
        countryRepository.save(usa);
        Author author1 = new Author("Petre", "M. Andreevski", macedonia);
        Author author2 = new Author("Mark", "Twain", usa);
        authorRepository.save(author1);
        authorRepository.save(author2);
        Book book1 = new Book("Pirej", CategoryEnum.NOVEL, author1, 5);
        Book book2 = new Book("The Adventures of Tom Sawyer", CategoryEnum.CLASSICS, author2, 3);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}
