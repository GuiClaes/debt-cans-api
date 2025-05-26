package com.canettes.duel.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Debt {

    @Id
    private String id;

    @Version
    private int version;

    @OneToOne
    private Player from;

    @OneToOne
    private Player to;

    private int amount;

    private Instant creationDate;

    public Debt() {
        //for jpa
    }

    public Debt(Player from, Player to, int amount) {
        this.id = UUID.randomUUID().toString();
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.creationDate = Instant.now();
    }

    public String getId() {
        return id;
    }

    public Player getFrom() {
        return from;
    }

    public Player getTo() {
        return to;
    }

    public int getAmount() {
        return amount;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Debt debt = (Debt) o;
        return Objects.equals(id, debt.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
