package com.example.gerenciamentoDeAlunos.service;

import com.example.gerenciamentoDeAlunos.entidade.Curso;
import com.example.gerenciamentoDeAlunos.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarCurso(){
        return cursoRepository.findAll();
    }

    public Curso salvarCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    public Curso atualizaCurso(Curso curso, Long id){
        curso.setId(id);
        return cursoRepository.save(curso);
    }

    public void deletarCurso(Long id){
        cursoRepository.deleteById(id);
    }

    public Optional<Curso> buscarCursoPorId(Long id){
        return cursoRepository.findById(id);
    }
}
