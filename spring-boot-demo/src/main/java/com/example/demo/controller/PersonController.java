package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {
        return ResponseEntity.status(201).body(personService.addPerson(person));
    }

    // @GetMapping
    // public ResponseEntity<List<Person>> getPeople() {
    //     return ResponseEntity.ok(personService.getAllPeople());
    // }
    @GetMapping
    public ResponseEntity<Page<Person>> getPeople(@PageableDefault(size = 5, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(personService.getPeople(pageable));
    }

    @GetMapping("/{id}") 
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(
            @PathVariable int id,
            @Valid @RequestBody Person person) {

        return ResponseEntity.ok(personService.updatePerson(id, person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
