package com.juanchavezcornejo.bowling.core.frames;

import com.juanchavezcornejo.bowling.core.BowlingException;
import com.juanchavezcornejo.bowling.core.score.Score;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EndFrameTest {
    @Test
    public void testSumWithNoSpareNoStrike() {
        EndFrame frame = new EndFrame();
        BowlingFrame mock = Mockito.mock(BowlingFrame.class);
        Mockito.when(mock.retrieveSum()).thenReturn(0);
        frame.setPrevious(mock);
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        frame.addScore(Score.THREE);
        assertEquals(6, frame.retrieveSum());
    }

    @Test
    public void testSumWithStrikeAndSpare1() {
        EndFrame frame = new EndFrame();
        BowlingFrame mock = Mockito.mock(BowlingFrame.class);
        Mockito.when(mock.retrieveSum()).thenReturn(0);
        frame.setPrevious(mock);
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);
        frame.addScore(Score.STRIKE);
        assertEquals(20, frame.retrieveSum());
    }

    @Test
    public void testSumWithStrikeAndSpare2() {
        EndFrame frame = new EndFrame();
        BowlingFrame mock = Mockito.mock(BowlingFrame.class);
        Mockito.when(mock.retrieveSum()).thenReturn(0);
        frame.setPrevious(mock);
        frame.addScore(Score.STRIKE);
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);
        assertEquals(20, frame.retrieveSum());
    }

    @Test
    public void testSumWithThreeStrikes() {
        EndFrame frame = new EndFrame();
        BowlingFrame mock = Mockito.mock(BowlingFrame.class);
        Mockito.when(mock.retrieveSum()).thenReturn(0);
        frame.setPrevious(mock);
        frame.addScore(Score.STRIKE);
        frame.addScore(Score.STRIKE);
        frame.addScore(Score.STRIKE);
        assertEquals(30, frame.retrieveSum());
    }

    @Test
    public void testSumWithNoRolls() {
        assertThrows(BowlingException.class, () -> {
            EndFrame frame = new EndFrame();
            frame.retrieveSum();
        });
    }

    @Test
    public void testRetrieveScoreListWithNoSpareNoStrike() {
        EndFrame frame = new EndFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        frame.addScore(Score.THREE);

        assertEquals(3, frame.retrieveScoreList().size());
        assertEquals(Score.ONE, frame.retrieveScoreList().get(0));
        assertEquals(Score.TWO, frame.retrieveScoreList().get(1));
        assertEquals(Score.THREE, frame.retrieveScoreList().get(2));
    }

    @Test
    public void testRetrieveScoreListWithStrike() {
        EndFrame frame = new EndFrame();
        frame.addScore(Score.STRIKE);
        frame.addScore(Score.NINE);
        frame.addScore(Score.ONE);

        assertEquals(3, frame.retrieveScoreList().size());
        assertEquals(Score.STRIKE, frame.retrieveScoreList().get(0));
        assertEquals(Score.NINE, frame.retrieveScoreList().get(1));
        assertEquals(Score.SPARE, frame.retrieveScoreList().get(2));
    }

    @Test
    public void testRetrieveScoreListWithSpare() {
        EndFrame frame = new EndFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);
        frame.addScore(Score.THREE);

        assertEquals(3, frame.retrieveScoreList().size());
        assertEquals(Score.ONE, frame.retrieveScoreList().get(0));
        assertEquals(Score.SPARE, frame.retrieveScoreList().get(1));
        assertEquals(Score.THREE, frame.retrieveScoreList().get(2));
    }

    @Test
    public void testAddMoreScores() {
        assertThrows(BowlingException.class, () -> {
            EndFrame frame = new EndFrame();
            frame.addScore(Score.ONE);
            frame.addScore(Score.NINE);
            frame.addScore(Score.ONE);
            frame.addScore(Score.ONE);
        });
    }

    @Test
    public void testAddNull() {
        assertThrows(BowlingException.class, () -> {
            EndFrame frame = new EndFrame();
            frame.addScore(null);
        });
    }

    @Test
    public void testHasStrikeWithValidStrike() {
        EndFrame frame = new EndFrame();
        frame.addScore(Score.STRIKE);
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        assertTrue(frame.hasStrike());
    }

    @Test
    public void testHasStrikeWithThreeStrikes() {
        EndFrame frame = new EndFrame();
        frame.addScore(Score.STRIKE);
        frame.addScore(Score.STRIKE);
        frame.addScore(Score.STRIKE);
        assertTrue(frame.hasStrike());
    }

    @Test
    public void testHasStrikeWithNoStrike() {
        EndFrame frame = new EndFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        frame.addScore(Score.THREE);
        assertFalse(frame.hasStrike());
    }


    @Test
    public void testHasStrikeWithValidSpare1() {
        EndFrame frame = new EndFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);
        frame.addScore(Score.ZERO);
        assertTrue(frame.hasSpare());
    }

    @Test
    public void testHasStrikeWithValidSpare2() {
        EndFrame frame = new EndFrame();
        frame.addScore(Score.STRIKE);
        frame.addScore(Score.NINE);
        frame.addScore(Score.ONE);
        assertTrue(frame.hasSpare());
    }

    @Test
    public void testHasStrikeWithNoSpare() {
        EndFrame frame = new EndFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        frame.addScore(Score.THREE);
        assertFalse(frame.hasSpare());
    }

    @Test
    public void testAddScore() {
        EndFrame frame = new EndFrame();
        assertTrue(frame.canAddScore());
        frame.addScore(Score.ONE);
        assertTrue(frame.canAddScore());
        frame.addScore(Score.TWO);
        assertTrue(frame.canAddScore());
        frame.addScore(Score.THREE);
        assertFalse(frame.canAddScore());
    }

    @Test
    public void testRetrieveSize() {
        EndFrame frame = new EndFrame();
        assertEquals(3, frame.retrieveSize());
    }

    @Test
    public void testSetNext() {
        assertThrows(BowlingException.class, () -> {
            EndFrame frame = new EndFrame();
            frame.setNext(null);
        });
    }
}
