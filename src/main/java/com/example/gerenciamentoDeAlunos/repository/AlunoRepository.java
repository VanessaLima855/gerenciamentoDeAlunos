package com.example.gerenciamentoDeAlunos.repository;

import com.example.gerenciamentoDeAlunos.entidade.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
