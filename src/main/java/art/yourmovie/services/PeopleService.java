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

    public List<Person> findAllUsers(Long id){
        return peopleRepository.findAll();
    }

    public Optional<Person> findUserById(Long id){
        return peopleRepository.findById(id);
    }

    public Person updateUser(String name, String password){
        return peopleRepository.save(new Person(name, password));
    }

    public void deleteUser(Long id) {
        peopleRepository.deleteById(id);
    }
}
