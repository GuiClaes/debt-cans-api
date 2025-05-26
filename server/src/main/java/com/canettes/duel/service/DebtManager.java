package com.canettes.duel.service;

import com.canettes.duel.dto.DebtCreationDto;
import com.canettes.duel.model.Debt;

import java.util.List;

public interface DebtManager {

    List<Debt> findAllDebts();

    List<Debt> findDebtsByPlayerId(String playerId);

    Debt createDebt(DebtCreationDto dto);
}
