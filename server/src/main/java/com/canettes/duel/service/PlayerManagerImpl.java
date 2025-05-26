package com.canettes.duel.service;

import com.canettes.duel.model.Player;
import com.canettes.duel.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Component
public class PlayerManagerImpl implements PlayerManager {
    private static final Logger logger = LoggerFactory.getLogger(PlayerManagerImpl.class);

    private final PlayerRepository playerRepository;

    public PlayerManagerImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Player> findAllPlayers() {
        return playerRepository.findAll().stream()
                .sorted(Comparator.comparing(Player::getName))
                .toList();
    }

    @Override
    @Transactional
    public Player createPlayer(String name) {
        final Player player = new Player(name);
        logger.info("Creating player with name: {}", name);
        return playerRepository.save(player);
    }
}
