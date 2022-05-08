package com.santandedr.bankline.api.controller;


import com.santandedr.bankline.api.dto.NovaMovimentacao;
import com.santandedr.bankline.api.model.Movimentacao;
import com.santandedr.bankline.api.repository.CorrentistaRepository;
import com.santandedr.bankline.api.repository.MovimentacaoRepository;
import com.santandedr.bankline.api.service.CorrentistaService;
import com.santandedr.bankline.api.service.MovimentacaoService;
import io.swagger.v3.core.util.Json;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimentacoes")
public class movimentacaoController {

    private MovimentacaoRepository repository;
    private MovimentacaoService service;

    public movimentacaoController(MovimentacaoRepository repository, MovimentacaoService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<Movimentacao> findAll(){
        return  repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao novaMovimentacao){
        System.out.printf(String.valueOf(novaMovimentacao));
        service.save(novaMovimentacao);
    }

    @GetMapping("/{idConta}")
    public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
        return repository.findByIdConta(idConta);
    }

}
