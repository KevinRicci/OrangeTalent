package br.com.lottery.betapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.lottery.betapi.model.Person;
import java.util.List;

import javax.validation.Valid;

import br.com.lottery.betapi.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/all")
    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }

    @PostMapping("/save")
    public Person createPerson(@Valid @RequestBody Person person){
        return personRepository.save(person);
    }
}
