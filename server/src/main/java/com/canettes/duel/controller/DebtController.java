package com.canettes.duel.controller;

import com.canettes.duel.dto.DebtCreationDto;
import com.canettes.duel.dto.DebtDto;
import com.canettes.duel.model.Debt;
import com.canettes.duel.service.DebtManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DebtController {

    private final DebtManager debtManager;

    public DebtController(DebtManager debtManager) {
        this.debtManager = debtManager;
    }

    @GetMapping("/duel/debt")
    public List<DebtDto> findAllDebts() {
        return debtManager.findAllDebts().stream()
                .map(DebtDto::from)
                .toList();
    }

    @PostMapping("/duel/debt")
    public DebtDto createDebt(@RequestBody DebtCreationDto creationDto) {
        final Debt debt = debtManager.createDebt(creationDto);
        return DebtDto.from(debt);
    }
}
