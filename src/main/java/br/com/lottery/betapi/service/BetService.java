package br.com.lottery.betapi.service;

import java.util.List;

import br.com.lottery.betapi.dto.BetDto;
import br.com.lottery.betapi.model.Bet;
import br.com.lottery.betapi.model.Person;

public interface BetService {

    Bet generateBet(Person person);

    BetDto findByEmailOrderedByCreationDate(String email);
}