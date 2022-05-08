package com.santandedr.bankline.api.repository;

import com.santandedr.bankline.api.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

    List<Movimentacao>findByIdConta(Integer idConta);
}
