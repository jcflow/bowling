package com.juanchavezcornejo.bowling.frames;

import com.juanchavezcornejo.bowling.score.Score;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartFrameTest {
    @Test
    public void testSumWithNoSpareNoStrike() {
        StartFrame frame = new StartFrame();
        BowlingFrame mock = new BowlingFrame() {
            @Override
            public int retrieveSum() {
                return 0;
            }

            @Override
            public Score retrieveNextScore(int i) {
                return Score.ONE;
            }

            @Override
            public void addScore(Score score) {

            }

            @Override
            public void setPrevious(BowlingFrame previous) {

            }

            @Override
            public BowlingFrame getPrevious() {
                return null;
            }

            @Override
            public void setNext(BowlingFrame next) {

            }

            @Override
            public BowlingFrame getNext() {
                return null;
            }

            @Override
            public boolean hasStrike() {
                return false;
            }

            @Override
            public boolean hasSpare() {
                return false;
            }

            @Override
            public boolean canAddScore() {
                return false;
            }

            @Override
            public List<Score> retrieveScoreList() {
                return null;
            }

            @Override
            public int retrieveSize() {
                return 0;
            }
        };
        frame.setNext(mock);
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        assertEquals(4, frame.retrieveSum());
    }

    @Test
    public void testSumWithStrike() {
        StartFrame frame = new StartFrame();
        BowlingFrame mock = new BowlingFrame() {
            @Override
            public int retrieveSum() {
                return 0;
            }

            @Override
            public Score retrieveNextScore(int i) {
                return Score.STRIKE;
            }

            @Override
            public void addScore(Score score) {

            }

            @Override
            public void setPrevious(BowlingFrame previous) {

            }

            @Override
            public BowlingFrame getPrevious() {
                return null;
            }

            @Override
            public void setNext(BowlingFrame next) {

            }

            @Override
            public BowlingFrame getNext() {
                return null;
            }

            @Override
            public boolean hasStrike() {
                return false;
            }

            @Override
            public boolean hasSpare() {
                return false;
            }

            @Override
            public boolean canAddScore() {
                return false;
            }

            @Override
            public List<Score> retrieveScoreList() {
                return null;
            }

            @Override
            public int retrieveSize() {
                return 0;
            }
        };
        frame.setNext(mock);
        frame.addScore(Score.STRIKE);
        assertEquals(30, frame.retrieveSum());
    }

    @Test
    public void testSumWithSpare() {
        StartFrame frame = new StartFrame();
        BowlingFrame mock = new BowlingFrame() {
            @Override
            public int retrieveSum() {
                return 0;
            }

            @Override
            public Score retrieveNextScore(int i) {
                return Score.ONE;
            }

            @Override
            public void addScore(Score score) {

            }

            @Override
            public void setPrevious(BowlingFrame previous) {

            }

            @Override
            public BowlingFrame getPrevious() {
                return null;
            }

            @Override
            public void setNext(BowlingFrame next) {

            }

            @Override
            public BowlingFrame getNext() {
                return null;
            }

            @Override
            public boolean hasStrike() {
                return false;
            }

            @Override
            public boolean hasSpare() {
                return false;
            }

            @Override
            public boolean canAddScore() {
                return false;
            }

            @Override
            public List<Score> retrieveScoreList() {
                return null;
            }

            @Override
            public int retrieveSize() {
                return 0;
            }
        };
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
        assertEquals(Score.NINE, frame.retrieveScoreList().get(1));
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
    void testHasStrikeWithValidSpare1() {
        StartFrame frame = new StartFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);
        assertTrue(frame.hasSpare());
    }

    @Test
    void testHasStrikeWithValidSpare2() {
        StartFrame frame = new StartFrame();
        frame.addScore(Score.NINE);
        frame.addScore(Score.ONE);
        assertTrue(frame.hasSpare());
    }

    @Test
    void testHasStrikeWithNoSpare() {
        StartFrame frame = new StartFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        assertFalse(frame.hasSpare());
    }

    @Test
    void testAddScore() {
        StartFrame frame = new StartFrame();
        assertTrue(frame.canAddScore());
        frame.addScore(Score.ONE);
        assertTrue(frame.canAddScore());
        frame.addScore(Score.TWO);
        assertFalse(frame.canAddScore());
    }

    @Test
    void testRetrieveSize() {
        StartFrame frame = new StartFrame();
        assertEquals(2, frame.retrieveSize());
    }
}
