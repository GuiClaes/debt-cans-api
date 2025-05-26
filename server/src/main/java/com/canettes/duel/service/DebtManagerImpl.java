package com.canettes.duel.service;

import com.canettes.duel.dto.DebtCreationDto;
import com.canettes.duel.model.Debt;
import com.canettes.duel.model.Player;
import com.canettes.duel.repository.DebtRepository;
import com.canettes.duel.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Component
public class DebtManagerImpl implements DebtManager {
    private static final Logger logger = LoggerFactory.getLogger(DebtManagerImpl.class);

    private final DebtRepository debtRepository;
    private final PlayerRepository playerRepository;

    public DebtManagerImpl(DebtRepository debtRepository,
                           PlayerRepository playerRepository) {
        this.debtRepository = debtRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Debt> findAllDebts() {
        return debtRepository.findAll().stream()
                .sorted(Comparator.comparing(Debt::getCreationDate).reversed())
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Debt> findDebtsByPlayerId(String playerId) {
        return Stream.concat(
            debtRepository.findByFrom_Id(playerId).stream(),
            debtRepository.findByTo_Id(playerId).stream()
        ).toList();
    }

    @Override
    @Transactional
    public Debt createDebt(DebtCreationDto dto) {
        //TODO Validate the DTO
        final Player playerFrom = playerRepository.findById(dto.getFromId())
                .orElseThrow();

        final Player playerTo = playerRepository.findById(dto.getToId())
                .orElseThrow();

        final Debt debt = new Debt(playerFrom, playerTo, dto.getAmount());

        logger.info("Debt created from {} to {} with amount {}", playerFrom.getId(), playerTo.getId(), dto.getAmount());
        return debtRepository.save(debt);
    }
}
