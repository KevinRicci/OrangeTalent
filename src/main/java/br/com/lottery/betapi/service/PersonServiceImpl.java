package br.com.lottery.betapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lottery.betapi.model.Bet;
import br.com.lottery.betapi.model.Person;
import br.com.lottery.betapi.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BetServiceImpl betServiceImpl;

    @Transactional
    @Override
    public Bet save(Person person) {
        if(emailNotExists(person)){
            person = personRepository.save(person);
            return betServiceImpl.generateBet(person);
        }else{
            person = personRepository.findByEmail(person.getEmail()).get(0);
            return betServiceImpl.generateBet(person);
        }
    } 

    public Boolean emailNotExists(Person person){
        return personRepository.findByEmail(person.getEmail()).isEmpty();
    } 
}