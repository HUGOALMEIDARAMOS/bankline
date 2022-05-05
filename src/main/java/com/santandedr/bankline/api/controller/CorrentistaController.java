package com.santandedr.bankline.api.controller;


import com.santandedr.bankline.api.dto.NovoCorrentista;
import com.santandedr.bankline.api.model.Correntista;
import com.santandedr.bankline.api.repository.CorrentistaRepository;
import com.santandedr.bankline.api.service.CorrentistaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/correntista")
public class CorrentistaController {

    private CorrentistaRepository repository;
    private CorrentistaService service;

    public CorrentistaController(CorrentistaRepository repository, CorrentistaService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<Correntista> findAll(){
        return  repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista correntista){
        service.save(correntista);
    }

}
