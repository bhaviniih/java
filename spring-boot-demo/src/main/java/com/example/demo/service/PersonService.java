package com.example.demo.service;

import com.example.demo.exception.PersonNotFoundException;
import com.example.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private List<Person> people = new ArrayList<>();
    private int counter = 1;

    public Person addPerson(Person person) {
        person.setId(counter++);
        people.add(person);
        return person;
    }

    public List<Person> getAllPeople() {
        return people;
    }

    public Person getPersonById(int id) {
        return people.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    public Person updatePerson(int id, Person updatedPerson) {
        Person person = getPersonById(id);
        person.setName(updatedPerson.getName());
        person.setAge(updatedPerson.getAge());
        return person;
    }

    public void deletePerson(int id) {
        Person person = getPersonById(id);
        people.remove(person);
    }
}
