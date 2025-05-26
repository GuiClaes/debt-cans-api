package com.canettes.duel.dto;

import com.canettes.duel.model.Player;

public class PlayerDto {

    public static PlayerDto from(Player player) {
        return new PlayerDto()
                .setId(player.getId())
                .setName(player.getName());
    }

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public PlayerDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlayerDto setName(String name) {
        this.name = name;
        return this;
    }
}
