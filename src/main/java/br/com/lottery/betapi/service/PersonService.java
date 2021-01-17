package br.com.lottery.betapi.service;

import br.com.lottery.betapi.model.Bet;
import br.com.lottery.betapi.model.Person;

public interface PersonService {
    
    Bet save(Person person);
}
