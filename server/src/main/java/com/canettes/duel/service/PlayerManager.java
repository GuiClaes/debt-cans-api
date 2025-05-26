package com.canettes.duel.service;

import com.canettes.duel.model.Player;

import java.util.List;

public interface PlayerManager {

    List<Player> findAllPlayers();

    Player createPlayer(String name);
}
