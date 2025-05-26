package com.canettes.duel.dto;

public class DebtCreationDto {
    private String fromId;
    private String toId;
    private int amount;

    public String getFromId() {
        return fromId;
    }

    public DebtCreationDto setFromId(String fromId) {
        this.fromId = fromId;
        return this;
    }

    public String getToId() {
        return toId;
    }

    public DebtCreationDto setToId(String toId) {
        this.toId = toId;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public DebtCreationDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
