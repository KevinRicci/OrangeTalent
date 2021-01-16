package br.com.lottery.betapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lottery.betapi.model.Bet;

public interface BetRepository extends JpaRepository<Bet, Long> {  
}
