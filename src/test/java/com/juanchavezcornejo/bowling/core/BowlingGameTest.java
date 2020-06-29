package com.juanchavezcornejo.bowling.core;

import com.juanchavezcornejo.bowling.core.score.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    @Test
    public void testAddPlayer() {
        BowlingGame game = new BowlingGame();
        BowlingPlayer player = new BowlingPlayer("Juan", 10);
        game.addPlayer(player);

        assertTrue(game.hasPlayerWithName("Juan"));
        assertEquals(player, game.getPlayerWithName("Juan"));
    }

    @Test
    public void testRetrieveFrameResultWithNoStrikeNoSpare() {
        BowlingGame game = new BowlingGame();
        BowlingPlayer player = new BowlingPlayer("Juan", 3);
        game.addPlayer(player);

        game.addScore("Juan", Score.ONE);
        game.addScore("Juan", Score.TWO);

        game.addScore("Juan", Score.THREE);
        game.addScore("Juan", Score.FOUR);

        game.addScore("Juan", Score.FIVE);
        game.addScore("Juan", Score.ONE);
        game.addScore("Juan", Score.TWO);

        assertEquals(6, player.retrieveFrameResult(0));
        assertEquals(13, player.retrieveFrameResult(1));
        assertEquals(21, player.retrieveFrameResult(2));
    }

    @Test
    public void testRetrieveFrameResultWithZeros() {
        BowlingGame game = new BowlingGame();
        BowlingPlayer player = new BowlingPlayer("Juan", 3);
        game.addPlayer(player);

        game.addScore("Juan", Score.ZERO);
        game.addScore("Juan", Score.ZERO);

        game.addScore("Juan", Score.ZERO);
        game.addScore("Juan", Score.ZERO);

        game.addScore("Juan", Score.ZERO);
        game.addScore("Juan", Score.ZERO);
        game.addScore("Juan", Score.ZERO);

        assertEquals(0, player.retrieveFrameResult(0));
        assertEquals(0, player.retrieveFrameResult(1));
        assertEquals(0, player.retrieveFrameResult(2));
    }


    @Test
    public void testRetrieveFrameResultWithSpare() {
        BowlingGame game = new BowlingGame();
        BowlingPlayer player = new BowlingPlayer("Juan", 3);
        game.addPlayer(player);

        game.addScore("Juan", Score.ONE);
        game.addScore("Juan", Score.NINE);

        game.addScore("Juan", Score.FIVE);
        game.addScore("Juan", Score.FIVE);

        game.addScore("Juan", Score.FIVE);
        game.addScore("Juan", Score.FIVE);
        game.addScore("Juan", Score.ONE);

        assertEquals(15, player.retrieveFrameResult(0));
        assertEquals(30, player.retrieveFrameResult(1));
        assertEquals(41, player.retrieveFrameResult(2));
    }

    @Test
    public void testRetrieveFrameResultWithFouls() {
        BowlingGame game = new BowlingGame();
        BowlingPlayer player = new BowlingPlayer("Juan", 3);
        game.addPlayer(player);

        game.addScore("Juan", Score.FOUL);
        game.addScore("Juan", Score.FOUL);

        game.addScore("Juan", Score.FOUL);
        game.addScore("Juan", Score.FOUL);

        game.addScore("Juan", Score.FOUL);
        game.addScore("Juan", Score.FOUL);
        game.addScore("Juan", Score.FOUL);

        assertEquals(0, player.retrieveFrameResult(0));
        assertEquals(0, player.retrieveFrameResult(1));
        assertEquals(0, player.retrieveFrameResult(2));
    }

    @Test
    public void testRetrieveFrameResultWithStrikes() {
        BowlingGame game = new BowlingGame();
        BowlingPlayer player = new BowlingPlayer("Juan", 3);
        game.addPlayer(player);

        game.addScore("Juan", Score.STRIKE);

        game.addScore("Juan", Score.STRIKE);

        game.addScore("Juan", Score.STRIKE);
        game.addScore("Juan", Score.STRIKE);
        game.addScore("Juan", Score.STRIKE);

        assertEquals(30, player.retrieveFrameResult(0));
        assertEquals(60, player.retrieveFrameResult(1));
        assertEquals(90, player.retrieveFrameResult(2));
    }
}
