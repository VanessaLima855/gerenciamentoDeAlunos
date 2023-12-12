package com.example.gerenciamentoDeAlunos.controller;

import com.example.gerenciamentoDeAlunos.entidade.Curso;
import com.example.gerenciamentoDeAlunos.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/curso")
@RequestMapping
public class CursoController {
    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/listar-cursos")
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> listarCursos(){
        return cursoService.listarCurso();

    }

    @PostMapping("/salvar-curso")
    public ResponseEntity<Curso> salvarCurso(@RequestBody Curso curso){
        Curso cursoSalvo = cursoService.salvarCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoSalvo);
    }

    @PutMapping("/atualizar-curso/{id}")
    public ResponseEntity<Curso> atualizarCurso(@RequestBody Curso curso,@PathVariable Long id){
        Optional<Curso> cursoExiste = cursoService.buscarCursoPorId(id);
        if (cursoExiste.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Curso cursoAtualizado = cursoService.atualizaCurso(curso,id);
        return ResponseEntity.status(HttpStatus.OK).body(cursoAtualizado);

    }

    @DeleteMapping("/deletar-curso/{id}")
    public ResponseEntity<Void> deletarCurso(@PathVariable Long id){
        Optional<Curso> cursoExiste = cursoService.buscarCursoPorId(id);
        if (cursoExiste.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        cursoService.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }


}
