package br.com.lottery.betapi.repository;

import br.com.lottery.betapi.model.Person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

    List<Person> findByEmail(String email);
}