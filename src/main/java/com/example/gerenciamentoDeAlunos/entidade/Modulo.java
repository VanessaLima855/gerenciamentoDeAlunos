package com.example.gerenciamentoDeAlunos.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "modulo")
@Entity
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

   //@ManyToOne





}
