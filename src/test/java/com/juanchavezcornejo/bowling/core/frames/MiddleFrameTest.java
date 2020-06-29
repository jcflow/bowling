package com.juanchavezcornejo.bowling.core.frames;

import com.juanchavezcornejo.bowling.core.BowlingException;
import com.juanchavezcornejo.bowling.core.score.Score;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiddleFrameTest {
    @Test
    public void testSumWithNoSpareNoStrike() {
        MiddleFrame frame = new MiddleFrame();
        BowlingFrame mock = Mockito.mock(BowlingFrame.class);
        Mockito.when(mock.retrieveSum()).thenReturn(0);
        frame.setPrevious(mock);
        frame.setNext(mock);
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        assertEquals(3, frame.retrieveSum());
    }

    @Test
    public void testSumWithStrike() {
        MiddleFrame frame = new MiddleFrame();
        BowlingFrame mock = Mockito.mock(BowlingFrame.class);
        Mockito.when(mock.retrieveSum()).thenReturn(0);
        Mockito.when(mock.retrieveNextScore(Mockito.anyInt())).thenReturn(Score.STRIKE);
        frame.setPrevious(mock);
        frame.setNext(mock);
        frame.addScore(Score.STRIKE);
        assertEquals(30, frame.retrieveSum());
    }

    @Test
    public void testSumWithSpare() {
        MiddleFrame frame = new MiddleFrame();
        BowlingFrame mock = Mockito.mock(BowlingFrame.class);
        Mockito.when(mock.retrieveSum()).thenReturn(0);
        Mockito.when(mock.retrieveNextScore(Mockito.anyInt())).thenReturn(Score.ONE);
        frame.setPrevious(mock);
        frame.setNext(mock);
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);
        assertEquals(11, frame.retrieveSum());
    }

    @Test
    public void testSumWithNoRolls() {
        assertThrows(BowlingException.class, () -> {
            MiddleFrame frame = new MiddleFrame();
            frame.retrieveSum();
        });
    }

    @Test
    public void testRetrieveScoreListWithNoSpareNoStrike() {
        MiddleFrame frame = new MiddleFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);

        assertEquals(2, frame.retrieveScoreList().size());
        assertEquals(Score.ONE, frame.retrieveScoreList().get(0));
        assertEquals(Score.TWO, frame.retrieveScoreList().get(1));
    }

    @Test
    public void testRetrieveScoreListWithStrike() {
        MiddleFrame frame = new MiddleFrame();
        frame.addScore(Score.STRIKE);

        assertEquals(1, frame.retrieveScoreList().size());
        assertEquals(Score.STRIKE, frame.retrieveScoreList().get(0));
    }

    @Test
    public void testRetrieveScoreListWithSpare() {
        MiddleFrame frame = new MiddleFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);

        assertEquals(2, frame.retrieveScoreList().size());
        assertEquals(Score.ONE, frame.retrieveScoreList().get(0));
        assertEquals(Score.SPARE, frame.retrieveScoreList().get(1));
    }

    @Test
    public void testAddMoreScores() {
        assertThrows(BowlingException.class, () -> {
            MiddleFrame frame = new MiddleFrame();
            frame.addScore(Score.ONE);
            frame.addScore(Score.NINE);
            frame.addScore(Score.ONE);
        });
    }

    @Test
    public void testAddNull() {
        assertThrows(BowlingException.class, () -> {
            MiddleFrame frame = new MiddleFrame();
            frame.addScore(null);
        });
    }

    @Test
    public void testHasStrikeWithValidStrike() {
        MiddleFrame frame = new MiddleFrame();
        frame.addScore(Score.STRIKE);
        assertTrue(frame.hasStrike());
    }

    @Test
    public void testHasStrikeWithInvalidStrike() {
        assertThrows(BowlingException.class, () -> {
            MiddleFrame frame = new MiddleFrame();
            frame.addScore(Score.ONE);
            frame.addScore(Score.STRIKE);
        });
    }

    @Test
    public void testHasStrikeWithNoStrike() {
        MiddleFrame frame = new MiddleFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        assertFalse(frame.hasStrike());
    }

    @Test
    public void testHasStrikeWithValidSpare1() {
        MiddleFrame frame = new MiddleFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);
        assertTrue(frame.hasSpare());
    }

    @Test
    public void testHasStrikeWithValidSpare2() {
        MiddleFrame frame = new MiddleFrame();
        frame.addScore(Score.NINE);
        frame.addScore(Score.ONE);
        assertTrue(frame.hasSpare());
    }

    @Test
    void testHasStrikeWithNoSpare() {
        MiddleFrame frame = new MiddleFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        assertFalse(frame.hasSpare());
    }

    @Test
    public void testAddScore() {
        MiddleFrame frame = new MiddleFrame();
        assertTrue(frame.canAddScore());
        frame.addScore(Score.ONE);
        assertTrue(frame.canAddScore());
        frame.addScore(Score.TWO);
        assertFalse(frame.canAddScore());
    }

    @Test
    public void testRetrieveSize() {
        MiddleFrame frame = new MiddleFrame();
        assertEquals(2, frame.retrieveSize());
    }
}
