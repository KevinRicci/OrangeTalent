package br.com.lottery.betapi.dto;

import br.com.lottery.betapi.model.Bet;

import java.util.ArrayList;
import java.util.List;

public class BetDto {

    private String email;
    private List<Integer> numbers;

    public BetDto() {
    }

    public BetDto convertToBetDto (List<Bet> bets){

            if(!bets.isEmpty()) {
                this.email = bets.get(0).getPerson().getEmail();
                this.numbers = new ArrayList<>();

                bets.forEach( bet -> {
                    this.numbers.add(bet.getNumbers());
                });

            }else{
                this.email = "";
            }

        return this;
    }

    public BetDto convertToBetDto(Bet bet){
        this.email = bet.getPerson().getEmail();
        this.numbers = new ArrayList<>();
        this.numbers.add(bet.getNumbers());

        return this;
    }

    public String getEmail() {
        return email;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}