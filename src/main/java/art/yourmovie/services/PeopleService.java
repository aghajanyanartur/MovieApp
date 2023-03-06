package art.yourmovie.services;

import art.yourmovie.models.Person;
import art.yourmovie.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public Person addUser(String name, String password){
        return peopleRepository.save(new Person(name, password));
    }

    public List<Person> findAllUsers(){
        return peopleRepository.findAll();
    }

    public Optional<Person> findUserById(Long id){
        return peopleRepository.findById(id);
    }

    public Optional<Person> findUserByUsername(String username){
        return peopleRepository.findByUsername(username);
    }

    public Optional<Person> findUserByPassword(String password){
        return peopleRepository.findByPassword(password);
    }

    public void updateUser(Person person, String name, String password){
        if(peopleRepository.findById(person.getId()).isPresent()){
            person = peopleRepository.findById(person.getId()).get();
            person.setUsername(name);
            person.setPassword(password);
            peopleRepository.save(person);
        }
    }

    public void deleteUser(Long id) {
        peopleRepository.deleteById(id);
    }

    public void deleteAll(){
        peopleRepository.deleteAll();
    }
}