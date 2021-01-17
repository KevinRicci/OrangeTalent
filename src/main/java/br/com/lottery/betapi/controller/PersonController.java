package br.com.lottery.betapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lottery.betapi.model.Bet;
import br.com.lottery.betapi.model.Person;


import javax.validation.Valid;

import br.com.lottery.betapi.service.PersonServiceImpl;

@RestController
@RequestMapping("/people")
public class PersonController {
    
    @Autowired
    private PersonServiceImpl personServiceImpl;

    @PostMapping("/generateBet")
    public ResponseEntity<Bet> createPersonAndGenerateBet(@Valid @RequestBody Person person){ 
        return ResponseEntity.ok(personServiceImpl.save(person));
    }
}
