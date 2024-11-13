package com.example.springdemojpa.controller;

import com.example.springdemojpa.entity.Person;
import com.example.springdemojpa.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personRepository.save(person);
    }
}
