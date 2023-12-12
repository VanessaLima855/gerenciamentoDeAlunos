package com.example.gerenciamentoDeAlunos.service;

import com.example.gerenciamentoDeAlunos.entidade.Aluno;
import com.example.gerenciamentoDeAlunos.entidade.Curso;
import com.example.gerenciamentoDeAlunos.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno salvarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(Aluno aluno, Long id){
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    public void deletarAluno(Long id){
        alunoRepository.deleteById(id);
    }

    public Optional<Aluno> buscarAlunoPorId(Long id){
        return alunoRepository.findById(id);
    }
}
