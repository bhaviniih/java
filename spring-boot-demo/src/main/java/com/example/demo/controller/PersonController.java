package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import com.example.demo.dto.PersonDTO;
import com.example.demo.mapper.PersonMapper;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@Valid @RequestBody PersonDTO dto) {
        // return ResponseEntity.status(201).body(personService.addPerson(person));

        Person saved = personService.addPerson(PersonMapper.toEntity(dto));
        return ResponseEntity.status(201).body(PersonMapper.toDTO(saved));
    }

    // @GetMapping
    // public ResponseEntity<List<Person>> getPeople() {
    //     return ResponseEntity.ok(personService.getAllPeople());
    // }
    @GetMapping
    public ResponseEntity<Page<PersonDTO>> getPeople(@PageableDefault(size = 5, sort = "id") Pageable pageable) {
        // return ResponseEntity.ok(personService.getPeople(pageable));

        Page<PersonDTO> dtoPage = personService.getPeople(pageable).map(PersonMapper::toDTO);
        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/{id}") 
    public ResponseEntity<PersonDTO> getPerson(@PathVariable int id) {
        // return ResponseEntity.ok(personService.getPersonById(id));
        return ResponseEntity.ok(
            PersonMapper.toDTO(personService.getPersonById(id))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @Valid @RequestBody PersonDTO dto) {

        // return ResponseEntity.ok(personService.updatePerson(id, person));

        Person updated = personService.updatePerson(id, PersonMapper.toEntity(dto));
        return ResponseEntity.ok(PersonMapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
