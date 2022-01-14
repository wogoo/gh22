package com.crudApi.crud.controller;

import com.crudApi.crud.model.Person;
import com.crudApi.crud.repository.PersonRepository;
import org.hibernate.mapping.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
@CrossOrigin("*")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> Persons() {return personRepository.findAll();}

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id) {
        return personRepository.findById(id)
                .map(person1 -> ResponseEntity.ok().body(person1))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person CustomerCreate(@RequestBody Person person) {
        personRepository.save(person);
        return person;
    }
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Person> Update(@PathVariable("id") long id, @RequestBody Person person) {
        return personRepository.findById(id).map(
                person1 -> {
                    person1.setName(person.getName());
                    person1.setCity((person.getCity()));
                    Person atualizado = personRepository.save(person1);
                    return ResponseEntity.ok().body(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return personRepository.findById(id)
                .map(person1 -> {
                            personRepository.deleteById(id);
                            return ResponseEntity.ok().build();
                        }).orElse(ResponseEntity.notFound().build());
    }


}
