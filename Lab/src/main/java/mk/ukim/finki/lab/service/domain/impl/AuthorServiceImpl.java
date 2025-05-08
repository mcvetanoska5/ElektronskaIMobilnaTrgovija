package mk.ukim.finki.lab.service.domain.impl;

import mk.ukim.finki.lab.model.domain.Author;
import mk.ukim.finki.lab.repository.AuthorRepository;
import mk.ukim.finki.lab.service.domain.AuthorService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
    @Override
    public Optional<Author> findById(long id) {
        return authorRepository.findById(id);
    }
    @Override
    public void deleteById(long id) {
        authorRepository.deleteById(id);
    }
    @Override
    public Optional<Author> save(Author author) {
        return Optional.of(authorRepository.save(author));
    }
    @Override
    public Optional<Author> update(long id, Author author) {
        return authorRepository.findById(id).map(a->{
            if(author.getCountry()!=null){
                a.setCountry(author.getCountry());
            }
            if(author.getName()!=null){
                a.setName(author.getName());
            }
            if(author.getSurname()!=null){
                a.setSurname(author.getSurname());
            }
            return authorRepository.save(a);
        });
    }
}