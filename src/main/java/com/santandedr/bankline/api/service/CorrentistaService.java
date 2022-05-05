package com.santandedr.bankline.api.service;

import com.santandedr.bankline.api.dto.NovoCorrentista;
import com.santandedr.bankline.api.model.Conta;
import com.santandedr.bankline.api.model.Correntista;
import com.santandedr.bankline.api.repository.CorrentistaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {

    private CorrentistaRepository repository;

    public CorrentistaService(CorrentistaRepository repository) {
        this.repository = repository;
    }

    public void save(NovoCorrentista novoCorrentista){
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setNome(novoCorrentista.getNome());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);

        repository.save(correntista);

    }
}
