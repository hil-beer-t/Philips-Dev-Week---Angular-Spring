package com.devweek.backend.Controller;

import com.devweek.backend.Entity.Regiao;
import com.devweek.backend.Repository.RegiaoRepository;
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
public class RegiaoController {

    private final RegiaoRepository regiaoRepository;

    public RegiaoController(RegiaoRepository regiaoRepository) {
        this.regiaoRepository = regiaoRepository;
    }

    @GetMapping("/regioes")
    public ResponseEntity<?> findAllRegioes(){
        try {
            List<Regiao> allRegioes = regiaoRepository.findAll();
            System.out.println("Achou");
            if (allRegioes.isEmpty())
                System.out.println("Vazia");
            return new ResponseEntity<>(allRegioes, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("regioes/{id}")
    public ResponseEntity<Regiao> findRegioesById(@PathVariable Long id){
        Optional<Regiao> regiaoOptional = regiaoRepository.findById(id);
        if (regiaoOptional.isPresent()){
            Regiao regiaoUnid = regiaoOptional.get();
            return new ResponseEntity<>(regiaoUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
