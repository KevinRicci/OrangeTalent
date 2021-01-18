package br.com.lottery.betapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lottery.betapi.dto.BetDto;
import br.com.lottery.betapi.exception.ResourceNotFoundException;
import br.com.lottery.betapi.service.BetServiceImpl;

@RestController
@RequestMapping("/bets")
public class BetController {

    @Autowired
    private BetServiceImpl betServiceImpl;

    @GetMapping("/{email}")
    public ResponseEntity<BetDto> findByEmailOrderedByCreationDate(@PathVariable("email") String email){
        BetDto result = betServiceImpl.findByEmailOrderedByCreationDate(email);
        if(result.getEmail().isEmpty()){
            throw new ResourceNotFoundException("bets", "email", email);
        }else{
            return ResponseEntity.ok(result);
        }
    }
}
