package br.com.lottery.betapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor //lombok
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties(value = "creationDate") //jackson
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "creation_date", nullable = false)
    @CreationTimestamp //hibernate
    @Temporal(TemporalType.TIMESTAMP) //javax
    private Date creationDate;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    @CPF
    private String cpf;

    @NotBlank   //javax
    private String email;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Bet> bets;
}