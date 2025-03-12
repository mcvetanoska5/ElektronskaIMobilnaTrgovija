package mk.ukim.finki.lab.web;

import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.BookU;
import mk.ukim.finki.lab.model.dto.BookDTO;
import mk.ukim.finki.lab.model.dto.BookUDTO;
import mk.ukim.finki.lab.service.BookService;
import mk.ukim.finki.lab.service.BookUService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarian/booksU")
public class BookUController {
    private final BookUService bookUService;
    public BookUController(BookUService bookUService) {
        this.bookUService = bookUService;
    }
    // Get all books
    @GetMapping
    public List<BookU> findAll() {
        return bookUService.findAll();
    }
    // Get book by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookU> findById(@PathVariable Long id) {
        return bookUService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // Create new book
    @PostMapping("/add")
    public ResponseEntity<BookU> save(@RequestBody BookUDTO bookUDTO) {
        return bookUService.save(bookUDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    // Update book
    @PutMapping("/edit/{id}")
    public ResponseEntity<BookU> update(@PathVariable Long id, @RequestBody BookUDTO bookUDTO) {
        return bookUService.update(id, bookUDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

