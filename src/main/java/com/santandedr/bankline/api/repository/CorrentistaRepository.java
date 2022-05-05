package com.santandedr.bankline.api.repository;

import com.santandedr.bankline.api.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista , Integer> {
}
