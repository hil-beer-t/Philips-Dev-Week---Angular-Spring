package com.devweek.backend.Controller;

import com.devweek.backend.Entity.IncidenciaExame;
import com.devweek.backend.Repository.IncidenciaExameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class IncidenciaController {

    private IncidenciaExameRepository incidenciaExameRepository;

    public IncidenciaController(IncidenciaExameRepository incidenciaExameRepository) {
        this.incidenciaExameRepository = incidenciaExameRepository;
    }

    @GetMapping("/incidencias")
    public ResponseEntity<List<IncidenciaExame>> findOcorrencias(){
        List<IncidenciaExame> listaIncidencia = incidenciaExameRepository.findAll();
        if (listaIncidencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<>(listaIncidencia, HttpStatus.OK);
    }

    @GetMapping("/incidencias/{id}")
    public ResponseEntity<IncidenciaExame> findOcorrenciasById(@PathVariable Long id){
        Optional<IncidenciaExame> incidenciaOptional = incidenciaExameRepository.findById(id);
        if (incidenciaOptional.isPresent()){
            IncidenciaExame ocorrenciaUnid = incidenciaOptional.get();
            return new ResponseEntity<>(ocorrenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
