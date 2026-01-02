package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.web.bind.annotation.*;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
// public class PersonController {

//     @GetMapping("/person")
//     public Person getPerson() {
//         return new Person("Dev", 22);
//     }

//     @GetMapping("/people")
//     public List<Person> getPeople() {
//         return List.of(
//             new Person("Dev", 22),
//             new Person("Alex", 30),
//             new Person("Sam", 28)
//         );
//     }
// }

public class PersonController {

    private List<Person> people = new ArrayList<>();

    @GetMapping("/people")
    public List<Person> getPeople() {
        return people;
    }

    @PostMapping("/people")
    public Person addPerson(@RequestBody Person person) {
        people.add(person);
        return person;
    }
}
