package com.example.gerenciamentoDeAlunos.controller;

import com.example.gerenciamentoDeAlunos.entidade.Modulo;
import com.example.gerenciamentoDeAlunos.service.ModuloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modulo")
public class ModuloController {
    private ModuloService moduloService;

    public ModuloController(ModuloService moduloService) {
        this.moduloService = moduloService;
    }
    @GetMapping("/listar-modulos")
    @ResponseStatus(HttpStatus.OK)
    public List<Modulo> listarModulos(){
        return moduloService.listarModulos();
    }

    @PostMapping("/salvar-modulo")
    public ResponseEntity<Modulo> salvarModulo(@RequestBody Modulo modulo){
        Modulo moduloSalvo = moduloService.salvarModulo(modulo);
        return ResponseEntity.status(HttpStatus.CREATED).body(moduloSalvo);
    }

    @PutMapping("/atualizar-modulo/{id}")
    public ResponseEntity<Modulo> atualizarModulo(@RequestBody Modulo modulo, @PathVariable Long id){
        Optional<Modulo> moduloExiste = moduloService.buscarModuloPorId(id);
        if (moduloExiste.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Modulo moduloAtualizado = moduloService.atualizarModulo(modulo,id);
        return ResponseEntity.status(HttpStatus.OK).body(moduloAtualizado);
    }

    @DeleteMapping("/deletar-modulo/{id}")
    public ResponseEntity<Void> deletarModulo(@PathVariable Long id){
        Optional<Modulo> moduloExiste = moduloService.buscarModuloPorId(id);
        if (moduloExiste.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        moduloService.deletarModulo(id);
        return ResponseEntity.noContent().build();
    }

}
