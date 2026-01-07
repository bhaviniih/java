package com.example.demo.service;

import com.example.demo.exception.PersonNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Person getPersonById(int id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    public Person updatePerson(int id, Person updatedPerson) {
        Person person = getPersonById(id);
        person.setName(updatedPerson.getName());
        person.setAge(updatedPerson.getAge());
        return personRepository.save(person);
    }

    public void deletePerson(int id) {
        Person person = getPersonById(id);
        personRepository.delete(person);
    }
}
