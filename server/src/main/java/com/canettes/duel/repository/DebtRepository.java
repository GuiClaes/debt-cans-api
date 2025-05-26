package com.canettes.duel.repository;

import com.canettes.duel.model.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebtRepository extends JpaRepository<Debt, String> {

    List<Debt> findByFrom_Id(String playerId);

    List<Debt> findByTo_Id(String playerId);
}
