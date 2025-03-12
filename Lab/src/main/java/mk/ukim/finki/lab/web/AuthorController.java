package mk.ukim.finki.lab.web;

import mk.ukim.finki.lab.service.AuthorService;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.dto.AuthorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/librarian/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    // Get all authors
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }
    // Get author by ID
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return authorService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Create new author
    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.save(authorDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    // Update author
    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        return authorService.update(id, authorDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        Optional<Author> author = authorService.findById(id);
        if (author.isPresent()) {
            authorService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
