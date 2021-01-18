package br.com.lottery.betapi.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lottery.betapi.dto.BetDto;
import br.com.lottery.betapi.model.Bet;
import br.com.lottery.betapi.model.Person;
import br.com.lottery.betapi.repository.BetRepository;

@Service
public class BetServiceImpl implements BetService {

    @Autowired
    private BetRepository betRepository;

    @Override
    public Bet generateBet(Person person) {
        Bet bet = new Bet();
        bet.setPerson(person);

        boolean iterator = true;
        while(iterator == true){
            Random createNumbers = new Random();
            int max = 999999;
            int min = 100000;
            int result = createNumbers.nextInt((max - min) + 1) + min;
            
            bet.setNumbers(result);
            iterator = checkRepeatedNumber(result, person);                                             
        }
        return betRepository.save(bet);
    }

    @Override
    public BetDto findByEmailOrderedByCreationDate(String email) {
        BetDto betDto = new BetDto();
        return betDto.convertToBetDto(betRepository.findByEmailOrderedByCreationDate(email));
    }

    public Boolean checkRepeatedNumber(int number, Person person){
        for(Bet b : person.getBets()){
            if(b.getNumbers() == number){
                return true;
            }
        }
        return false;
    }
}
