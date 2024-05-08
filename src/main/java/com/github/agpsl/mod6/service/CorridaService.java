package com.github.agpsl.mod6.service;

import com.github.agpsl.mod6.repository.CorridaRepository;
import com.github.agpsl.mod6.entity.Corrida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorridaService {
    @Autowired
    CorridaRepository corridaRepository;

    // Create
    public Corrida save(Corrida corrida) {
        return corridaRepository.save(corrida);
    }

    // Read
    public List<Corrida> getAll() {
        return corridaRepository.findAll();
    }

    public Corrida getById(Integer id) {
        return corridaRepository.findById(id).orElse(null);
    }

    public Long getCorridaDuracao(Integer id) {
        Corrida corrida = corridaRepository.findById(id).orElse(null);
        if (corrida != null) {
            return corrida.getCorridaDuracao();
        } else {
            return null;
        }
    }

    // Update
    public Corrida update(Integer id, Corrida corrida) {
       Corrida corridaAtualizada =  corridaRepository.findById(id).orElse(null);
       if (corridaAtualizada != null) {
           corridaAtualizada.setCorridaInicio(corrida.getCorridaInicio());
           corridaAtualizada.setCorridaDistancia(corrida.getCorridaDistancia());
           corridaAtualizada.setCorridaFinal(corrida.getCorridaFinal());
           corridaAtualizada.setCorridaLocal(corrida.getCorridaLocal());
           return corridaRepository.save(corridaAtualizada);
       } else {
           return null;
       }
    }

    // Delete
    public Boolean deleteCorrida(Integer id) {
        Corrida corrida = corridaRepository.findById(id).orElse(null);
        if (corrida != null) {
            corridaRepository.delete(corrida);
            return true;
        } else {
            return false;
        }
    }
}
