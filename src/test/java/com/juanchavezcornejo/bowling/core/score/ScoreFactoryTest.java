package com.juanchavezcornejo.bowling.core.score;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreFactoryTest {
    @Test
    public void testCreateScoreWithValidParameters() {
        Score score = ScoreFactory.createScore("0");
        assertEquals(score, Score.ZERO);

        score = ScoreFactory.createScore("1");
        assertEquals(score, Score.ONE);

        score = ScoreFactory.createScore("2");
        assertEquals(score, Score.TWO);

        score = ScoreFactory.createScore("3");
        assertEquals(score, Score.THREE);

        score = ScoreFactory.createScore("4");
        assertEquals(score, Score.FOUR);

        score = ScoreFactory.createScore("5");
        assertEquals(score, Score.FIVE);

        score = ScoreFactory.createScore("6");
        assertEquals(score, Score.SIX);

        score = ScoreFactory.createScore("7");
        assertEquals(score, Score.SEVEN);

        score = ScoreFactory.createScore("8");
        assertEquals(score, Score.EIGHT);

        score = ScoreFactory.createScore("9");
        assertEquals(score, Score.NINE);

        score = ScoreFactory.createScore("10");
        assertEquals(score, Score.STRIKE);

        score = ScoreFactory.createScore("F");
        assertEquals(score, Score.FOUL);
    }
}
