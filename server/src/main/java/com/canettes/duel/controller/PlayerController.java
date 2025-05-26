package com.canettes.duel.controller;

import com.canettes.duel.dto.PlayerDto;
import com.canettes.duel.model.Player;
import com.canettes.duel.service.PlayerManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerManager playerManager;

    public PlayerController(PlayerManager playerManager) {
        this.playerManager = playerManager;
    }

    @GetMapping("/duel/player")
    public List<PlayerDto> findAllPlayers() {
        return playerManager.findAllPlayers().stream()
                .map(PlayerDto::from)
                .toList();
    }

    @PostMapping("/duel/player")
    public PlayerDto createPlayer(@RequestParam String name) {
        final Player player = playerManager.createPlayer(name);
        return PlayerDto.from(player);
    }
}
