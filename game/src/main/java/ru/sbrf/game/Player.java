package ru.sbrf.game;

import java.util.Objects;
import java.util.UUID;

public class Player {

    private UUID id;
    private Race race;
    private PlayerState playerState;
    private Integer damage;


    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }


    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) && race == player.race;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }
}
