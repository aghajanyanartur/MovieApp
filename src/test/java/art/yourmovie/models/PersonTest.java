package art.yourmovie.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void init(){
        person = new Person("John", "john123");
    }

    @Test
    public void givenPerson_whenGettersAndSetters_thenSucceed() {
        // given
        // person is initialized in @BeforeEach
        // when
        String name = "John";
        String password = "john123";
        // then
        assertEquals(name, person.getUsername());
        assertEquals(password, person.getPassword());

        // when
        person.setUsername("Jack");
        person.setPassword("jack123");
        // then
        assertEquals("Jack", person.getUsername());
        assertEquals("jack123", person.getPassword());
    }

    @Test
    public void givenPerson_whenEquals_thenSucceed() {
        // given
        Person p1 = new Person("John", "john123");
        Person p2 = new Person("John", "jack000");
        Person p3 = new Person("Jack", "john123");
        Person p4 = null;
        // when
        // then
        assertEquals(person, p1);
        assertNotEquals(person, p2);
        assertNotEquals(person, p3);
        assertNotEquals(person, p4);
    }

    @Test
    public void givenPerson_whenHashCode_thenSucceed(){
        // given
        Person p1 = new Person("John", "john123");
        // when
        // then
        assertEquals(person.hashCode(), p1.hashCode());
    }

    @Test
    public void testToString() {
        // given
        // person is initialized in @BeforeEach
        // when
        String expected = "User{" + "id=" + 0 + ", username='" + "John" + '\'' + '}';
        // then
        assertEquals(expected, person.toString());
    }
}