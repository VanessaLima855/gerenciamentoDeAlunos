package com.example.gerenciamentoDeAlunos.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "aula")
@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

   // @ManyToOne
   // @JoinColumn(name = "modulo_id")
   // private Modulo modulo;

}
