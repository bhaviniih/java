package com.example.demo.mapper;

import com.example.demo.dto.PersonDTO;
import com.example.demo.model.Person;

public class PersonMapper {

    public static PersonDTO toDTO(Person person) {
        return new PersonDTO(
                person.getId(),
                person.getName(),
                person.getAge()
        );
    }

    public static Person toEntity(PersonDTO dto) {
        Person person = new Person();
        person.setName(dto.getName());
        person.setAge(dto.getAge());
        return person;
    }
}
