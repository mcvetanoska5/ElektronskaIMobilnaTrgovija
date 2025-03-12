package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.BookU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookURepository extends JpaRepository<BookU, Long> {
}
