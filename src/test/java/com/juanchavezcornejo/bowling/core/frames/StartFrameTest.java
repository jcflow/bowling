package com.juanchavezcornejo.bowling.core.frames;

import com.juanchavezcornejo.bowling.core.score.Score;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartFrameTest {
    @Test
    public void testSumWithNoSpareNoStrike() {
        StartFrame frame = new StartFrame();
        BowlingFrame mock = Mockito.mock(BowlingFrame.class);
        Mockito.when(mock.retrieveSum()).thenReturn(0);
        Mockito.when(mock.retrieveNextScore(Mockito.anyInt())).thenReturn(Score.ONE);
        frame.setNext(mock);
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        assertEquals(4, frame.retrieveSum());
    }

    @Test
    public void testSumWithStrike() {
        StartFrame frame = new StartFrame();
        BowlingFrame mock = Mockito.mock(BowlingFrame.class);
        Mockito.when(mock.retrieveSum()).thenReturn(0);
        Mockito.when(mock.retrieveNextScore(Mockito.anyInt())).thenReturn(Score.STRIKE);
        frame.setNext(mock);
        frame.addScore(Score.STRIKE);
        assertEquals(30, frame.retrieveSum());
    }

    @Test
    public void testSumWithSpare() {
        StartFrame frame = new StartFrame();
        BowlingFrame mock = Mockito.mock(BowlingFrame.class);
        Mockito.when(mock.retrieveSum()).thenReturn(0);
        Mockito.when(mock.retrieveNextScore(Mockito.anyInt())).thenReturn(Score.ONE);
        frame.setNext(mock);
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);
        assertEquals(11, frame.retrieveSum());
    }

    @Test
    public void testRetrieveScoreListWithNoSpareNoStrike() {
        StartFrame frame = new StartFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);

        assertEquals(2, frame.retrieveScoreList().size());
        assertEquals(Score.ONE, frame.retrieveScoreList().get(0));
        assertEquals(Score.TWO, frame.retrieveScoreList().get(1));
    }

    @Test
    public void testRetrieveScoreListWithStrike() {
        StartFrame frame = new StartFrame();
        frame.addScore(Score.STRIKE);

        assertEquals(1, frame.retrieveScoreList().size());
        assertEquals(Score.STRIKE, frame.retrieveScoreList().get(0));
    }

    @Test
    public void testRetrieveScoreListWithSpare() {
        StartFrame frame = new StartFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);

        assertEquals(2, frame.retrieveScoreList().size());
        assertEquals(Score.ONE, frame.retrieveScoreList().get(0));
        assertEquals(Score.SPARE, frame.retrieveScoreList().get(1));
    }

    @Test
    public void testHasStrikeWithValidStrike() {
        StartFrame frame = new StartFrame();
        frame.addScore(Score.STRIKE);
        assertTrue(frame.hasStrike());
    }

    @Test
    public void testHasStrikeWithInvalidStrike() {
        StartFrame frame = new StartFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.STRIKE);
        assertFalse(frame.hasStrike());
    }

    @Test
    public void testHasStrikeWithNoStrike() {
        StartFrame frame = new StartFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        assertFalse(frame.hasStrike());
    }

    @Test
    public void testHasStrikeWithValidSpare1() {
        StartFrame frame = new StartFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);
        assertTrue(frame.hasSpare());
    }

    @Test
    public void testHasStrikeWithValidSpare2() {
        StartFrame frame = new StartFrame();
        frame.addScore(Score.NINE);
        frame.addScore(Score.ONE);
        assertTrue(frame.hasSpare());
    }

    @Test
    public void testHasStrikeWithNoSpare() {
        StartFrame frame = new StartFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        assertFalse(frame.hasSpare());
    }

    @Test
    public void testAddScore() {
        StartFrame frame = new StartFrame();
        assertTrue(frame.canAddScore());
        frame.addScore(Score.ONE);
        assertTrue(frame.canAddScore());
        frame.addScore(Score.TWO);
        assertFalse(frame.canAddScore());
    }

    @Test
    public void testRetrieveSize() {
        StartFrame frame = new StartFrame();
        assertEquals(2, frame.retrieveSize());
    }
}
