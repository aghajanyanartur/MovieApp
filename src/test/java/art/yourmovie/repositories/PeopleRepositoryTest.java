package art.yourmovie.repositories;

import art.yourmovie.models.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PeopleRepositoryTest {

    @Autowired
    private PeopleRepository repository;

    @Test
    public void givenUsername_whenFindByUsername_thenShouldReturnOptionalPerson() {
        // Given
        repository.deleteAll();
        Person person = new Person("John", "john123");
        repository.save(person);
        // When
        Optional<Person> result = repository.findByUsername("John");
        Optional<Person> result2 = repository.findByUsername("Jack");
        // Then
        assertTrue(result.isPresent());
        assertEquals(person, result.get());
        assertFalse(result2.isPresent());
    }

    @Test
    public void givenPassword_whenFindByPassword_thenShouldReturnOptionalPerson() {
        // Given
        repository.deleteAll();
        Person person = new Person("John", "john123");
        repository.save(person);
        // When
        Optional<Person> result = repository.findByPassword("john123");
        Optional<Person> result2 = repository.findByPassword("jack000");
        // Then
        assertTrue(result.isPresent());
        assertEquals(person, result.get());
        assertFalse(result2.isPresent());
    }
}