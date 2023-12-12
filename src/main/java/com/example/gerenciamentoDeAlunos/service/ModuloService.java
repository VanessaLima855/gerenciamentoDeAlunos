package com.example.gerenciamentoDeAlunos.service;

import com.example.gerenciamentoDeAlunos.entidade.Modulo;
import com.example.gerenciamentoDeAlunos.repository.ModuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloService {
    private ModuloRepository moduloRepository;

    public ModuloService(ModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
    }

    public List<Modulo> listarModulos(){
        return moduloRepository.findAll();
    }

    public Modulo salvarModulo(Modulo modulo){
        return moduloRepository.save(modulo);
    }

    public Modulo atualizarModulo(Modulo modulo, Long id){
        modulo.setId(id);
        return moduloRepository.save(modulo);
    }

    public void deletarModulo(Long id){
      moduloRepository.deleteById(id);
    }

    public Optional<Modulo> buscarModuloPorId(Long id){
      return moduloRepository.findById(id);

    }
}
