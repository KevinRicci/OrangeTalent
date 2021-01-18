package br.com.lottery.betapi.service;

import br.com.lottery.betapi.dto.BetDto;
import br.com.lottery.betapi.model.Person;

public interface PersonService {
    
    BetDto save(Person person);
}
