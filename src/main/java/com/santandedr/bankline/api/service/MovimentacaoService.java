package com.santandedr.bankline.api.service;

import com.santandedr.bankline.api.dto.NovaMovimentacao;
import com.santandedr.bankline.api.model.Correntista;
import com.santandedr.bankline.api.model.Movimentacao;
import com.santandedr.bankline.api.model.MovimentacaoTipo;
import com.santandedr.bankline.api.repository.CorrentistaRepository;
import com.santandedr.bankline.api.repository.MovimentacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {

    private MovimentacaoRepository repository;
    private CorrentistaRepository correntistaRepository;

    public MovimentacaoService(MovimentacaoRepository repository, CorrentistaRepository correntistaRepository) {
        this.repository = repository;
        this.correntistaRepository = correntistaRepository;
    }

    public void save(NovaMovimentacao novaMovimentacao){

        Movimentacao movimentacao = new Movimentacao();

        Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);

        if(correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo()+valor);
            correntistaRepository.save(correntista);
        }


       repository.save(movimentacao);


    }
}
