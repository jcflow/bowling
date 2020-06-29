package com.juanchavezcornejo.bowling.core;

import com.juanchavezcornejo.bowling.core.score.Score;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    public static final int FRAMES_SIZE = 10;

    private List<BowlingPlayer> players;

    public BowlingGame() {
        this.players =  new ArrayList<>();
    }

    public void addPlayer(BowlingPlayer player) {
        if (player != null && !this.players.contains(player)) {
            this.players.add(player);
        }
    }

    public List<BowlingPlayer> getPlayers() {
        return players;
    }

    public BowlingPlayer getPlayerWithName(String name) {
        return this.players.stream().filter(player -> player.getName().equals(name)).findFirst().orElse(null);
    }

    public boolean hasPlayerWithName(String name) {
        BowlingPlayer result = this.getPlayerWithName(name);
        return result != null;
    }

    public void addScore(String name, Score score) {
        BowlingPlayer result = this.getPlayerWithName(name);
        if (result == null) {
            throw new RuntimeException();
        }
        result.addScore(score);
    }
}
