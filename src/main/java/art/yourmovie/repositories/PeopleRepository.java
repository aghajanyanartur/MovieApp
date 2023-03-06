package art.yourmovie.repositories;

import art.yourmovie.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {
    @Query
    Optional<Person> findByUsername(String username);
    @Query
    Optional<Person> findByPassword(String password);
}