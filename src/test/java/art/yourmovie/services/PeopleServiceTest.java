package art.yourmovie.services;

import art.yourmovie.models.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PeopleServiceTest {

    @Autowired
    private PeopleService peopleService;

    @Test
    void givenNewUser_whenAddUser_thenUserIsSaved() {
        // Given
        peopleService.deleteAll();
        String name = "John";
        String password = "password";
        // When
        Person savedPerson = peopleService.addUser(name, password);
        // Then
        assertEquals(name, savedPerson.getUsername());
        assertEquals(password, savedPerson.getPassword());
    }

    @Test
    void givenExistingUsers_whenFindAllUsers_thenAllUsersAreReturned() {
        // Given
        peopleService.deleteAll();
        peopleService.addUser("John", "password1");
        peopleService.addUser("Jack", "password2");
        // When
        List<Person> people = peopleService.findAllUsers();
        // Then
        assertEquals(2, people.size());
    }

    @Test
    void givenExistingUser_whenFindUserById_thenUserIsReturned() {
        // Given
        peopleService.deleteAll();
        Person savedPerson = peopleService.addUser("John", "password");
        // When
        Optional<Person> foundPerson = peopleService.findUserById(savedPerson.getId());
        // Then
        assertTrue(foundPerson.isPresent());
        assertEquals(savedPerson, foundPerson.get());
    }

    @Test
    void givenExistingUser_whenFindUserByUsername_thenUserIsReturned() {
        // Given
        peopleService.deleteAll();
        String name = "John";
        String password = "password";
        peopleService.addUser(name, password);
        // When
        Optional<Person> foundPerson = peopleService.findUserByUsername(name);
        // Then
        assertTrue(foundPerson.isPresent());
        assertEquals(name, foundPerson.get().getUsername());
        assertEquals(password, foundPerson.get().getPassword());
    }

    @Test
    void givenExistingUser_whenFindUserByPassword_thenUserIsReturned() {
        // Given
        peopleService.deleteAll();
        String name = "John";
        String password = "password";
        peopleService.addUser(name, password);
        // When
        Optional<Person> foundPerson = peopleService.findUserByPassword(password);
        // Then
        assertTrue(foundPerson.isPresent());
        assertEquals(name, foundPerson.get().getUsername());
        assertEquals(password, foundPerson.get().getPassword());
    }

    @Test
    void givenExistingUser_whenUpdateUser_thenUserIsUpdated() {
        // Given
        peopleService.deleteAll();
        Person person = peopleService.addUser("John", "password");
        long initialId = person.getId();
        String newName = "Jack";
        String newPassword = "newPassword";
        // When
        peopleService.updateUser(person, newName, newPassword);
        Person updated = peopleService.findUserById(person.getId()).orElse(person);
        // Then
        assertEquals(initialId, updated.getId());
        assertEquals(newName, updated.getUsername());
        assertEquals(newPassword, updated.getPassword());
    }

    @Test
    void givenExistingUser_whenDeleteUser_thenUserIsDeleted() {
        // Given
        peopleService.deleteAll();
        Person savedPerson = peopleService.addUser("John", "password");
        // When
        peopleService.deleteUser(savedPerson.getId());
        Optional<Person> foundPerson = peopleService.findUserById(savedPerson.getId());
        // Then
        assertFalse(foundPerson.isPresent());
    }
}