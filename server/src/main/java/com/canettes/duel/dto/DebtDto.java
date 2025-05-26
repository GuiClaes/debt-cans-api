package com.canettes.duel.dto;

import com.canettes.duel.model.Debt;

import java.time.Instant;

public class DebtDto {

    public static DebtDto from(Debt debt) {
        return new DebtDto()
                .setFrom(PlayerDto.from(debt.getFrom()))
                .setTo(PlayerDto.from(debt.getTo()))
                .setAmount(debt.getAmount())
                .setCreationDate(debt.getCreationDate());
    }

    private PlayerDto from;
    private PlayerDto to;
    private int amount;
    private Instant creationDate;

    public PlayerDto getFrom() {
        return from;
    }

    public DebtDto setFrom(PlayerDto from) {
        this.from = from;
        return this;
    }

    public PlayerDto getTo() {
        return to;
    }

    public DebtDto setTo(PlayerDto to) {
        this.to = to;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public DebtDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public DebtDto setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
        return this;
    }
}
