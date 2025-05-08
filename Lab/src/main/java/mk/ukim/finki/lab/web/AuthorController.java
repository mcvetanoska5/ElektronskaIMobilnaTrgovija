package mk.ukim.finki.lab.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.ukim.finki.lab.dto.CreateAuthorDTO;
import mk.ukim.finki.lab.service.application.AuthorApplicationService;
import mk.ukim.finki.lab.service.application.impl.CountryApplicationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
@Tag(name = "Authors", description = "Author management API for librarians")
public class AuthorController {
    private final AuthorApplicationService authorApplicationService;
    private final CountryApplicationServiceImpl countryApplicationService;
    public AuthorController(AuthorApplicationService authorApplicationService, CountryApplicationServiceImpl countryApplicationService) {
        this.authorApplicationService = authorApplicationService;
        this.countryApplicationService = countryApplicationService;
    }
    @GetMapping
    @Operation(summary = "List all authors")
    public ResponseEntity<?> listAllAuthors() {
        return ResponseEntity.status(HttpStatus.OK).body(authorApplicationService.findAll());
    }
    @GetMapping("/{id}")
    @Operation(summary = "List specific author")
    public ResponseEntity<?> listAuthor(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(authorApplicationService.findById(id));
    }
    @PostMapping("/add")
    @Operation(summary = "Add a new author", description = "Adds an author with details provided in the request body")
    public ResponseEntity<?> addAuthor(@RequestBody CreateAuthorDTO authorDto) {
        return ResponseEntity.ok(authorApplicationService.save(authorDto));
    }
    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit an author", description = "Edits an existing author's details")
    public ResponseEntity<?> editAuthor(@RequestBody CreateAuthorDTO authorDto, @PathVariable Long id) {
        return ResponseEntity.ok(authorApplicationService.update(id, authorDto));
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete an author", description = "Deletes an author by its ID")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        authorApplicationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/per-country")
    @Operation(summary = "")
    public ResponseEntity<?> findAllNumberOfAuthorsPerCountry() {
        return ResponseEntity.status(HttpStatus.OK).body(countryApplicationService.findAllAuthorsPerCountry());
    }
    @GetMapping("/per-country/{id}")
    @Operation(summary = "")
    public ResponseEntity<?> findNumberOfAuthorsPerCountry(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(countryApplicationService.findAuthorsPerCountry(id));
    }
}

