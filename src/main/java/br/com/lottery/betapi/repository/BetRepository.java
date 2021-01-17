package br.com.lottery.betapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.lottery.betapi.model.Bet;

public interface BetRepository extends JpaRepository<Bet, Long> {
    
    @Query(value = "select * from bet as b inner join person as p on p.id = b.person_id where p.email = ?1 order by b.creation_date", nativeQuery = true)
    List<Bet> findByEmailOrderedByCreationDate(String email);
}
