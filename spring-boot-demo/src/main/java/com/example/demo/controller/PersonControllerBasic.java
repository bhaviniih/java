// package com.example.demo.controller;

// import com.example.demo.model.Person;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.http.ResponseEntity;

// import com.example.demo.exception.PersonNotFoundException;

// import java.util.ArrayList;
// import java.util.List;

// @RestController
// public class PersonControllerBasic {

//     private List<Person> people = new ArrayList<>();

//     // Get All
//     @GetMapping("/people")
//     public ResponseEntity<List<Person>> getPeople() {
//         return ResponseEntity.ok(people);
//     }

//     // Create
//     @PostMapping("/people")
//     public ResponseEntity<Person> addPerson(@RequestBody Person person) {
//         people.add(person);
//         return ResponseEntity.status(201).body(person);
//     }

//     // Get Single
//     @GetMapping("/{id}")
//     public ResponseEntity<Person> getPersonById(@PathVariable int id) {
//         // for (Person p : people) {
//         //     if (p.getId() == id) {
//         //         return p;
//         //     }
//         // }
//         // return null; // handled better later

//         // return people.stream().filter(p -> p.getId() == id).findFirst().map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

//         Person person = people.stream()
//             .filter(p -> p.getId() == id)
//             .findFirst()
//             .orElseThrow(() -> new PersonNotFoundException(id));

//         return ResponseEntity.ok(person);
//     }

//     // UPDATE
//     @PutMapping("/{id}")
//     public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person updatedPerson) {
//         // for (Person p : people) {
//         //     if (p.getId() == id) {
//         //         p.setName(updatedPerson.getName());
//         //         p.setAge(updatedPerson.getAge());
//         //         return ResponseEntity.ok(p);
//         //     }
//         // }
//         // return ResponseEntity.notFound().build();

//         Person person = people.stream()
//             .filter(p -> p.getId() == id)
//             .findFirst()
//             .orElseThrow(() -> new PersonNotFoundException(id));

//         person.setName(updatedPerson.getName());
//         person.setAge(updatedPerson.getAge());

//         return ResponseEntity.ok(person);
//     }

//     // DELETE
//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deletePerson(@PathVariable int id) {
//         // boolean removed = people.removeIf(p -> p.getId() == id);

//         // if (removed) {
//         //     return ResponseEntity.noContent().build(); // 204
//         // }
//         // return ResponseEntity.notFound().build(); // 404

//         Person person = people.stream()
//             .filter(p -> p.getId() == id)
//             .findFirst()
//             .orElseThrow(() -> new PersonNotFoundException(id));

//         people.remove(person);
//         return ResponseEntity.noContent().build();
//     }
// }
