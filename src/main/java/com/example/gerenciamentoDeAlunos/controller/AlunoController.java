package com.example.gerenciamentoDeAlunos.controller;

import com.example.gerenciamentoDeAlunos.entidade.Aluno;
import com.example.gerenciamentoDeAlunos.entidade.Curso;
import com.example.gerenciamentoDeAlunos.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/listar-alunos")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listarAlunos(){
        return alunoService.listarAlunos();
    }

    @PostMapping("/salvar-aluno")
    public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno){
        Aluno alunoSalvo = alunoService.salvarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    @PutMapping("/atualizar-aluno/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@RequestBody Aluno aluno, @PathVariable Long id){
        Optional<Aluno> alunoExiste = alunoService.buscarAlunoPorId(id);

        if (alunoExiste.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Aluno alunoAtualizado = alunoService.atualizarAluno(aluno, id);
        return ResponseEntity.status(HttpStatus.OK).body(alunoAtualizado);

    }

    @DeleteMapping("/deletar-aluno/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id){
        Optional<Aluno> alunoExite = alunoService.buscarAlunoPorId(id);
        if (alunoExite.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        alunoService.deletarAluno(id);
       return ResponseEntity.noContent().build();

    }
}
