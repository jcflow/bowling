package com.juanchavezcornejo.bowling.core.frames;

import com.juanchavezcornejo.bowling.core.score.Score;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiddleFrameTest {
    @Test
    public void testSumWithNoSpareNoStrike() {
        MiddleFrame frame = new MiddleFrame();
        BowlingFrame mock = new BowlingFrame() {
            @Override
            public int retrieveSum() {
                return 0;
            }

            @Override
            public Score retrieveNextScore(int i) {
                return null;
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
        frame.setPrevious(mock);
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        assertEquals(3, frame.retrieveSum());
    }

    @Test
    public void testSumWithStrike() {
        MiddleFrame frame = new MiddleFrame();
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
        frame.setPrevious(mock);
        frame.setNext(mock);
        frame.addScore(Score.STRIKE);
        assertEquals(30, frame.retrieveSum());
    }

    @Test
    public void testSumWithSpare() {
        MiddleFrame frame = new MiddleFrame();
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
        frame.setPrevious(mock);
        frame.setNext(mock);
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);
        assertEquals(11, frame.retrieveSum());
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
    public void testHasStrikeWithValidStrike() {
        MiddleFrame frame = new MiddleFrame();
        frame.addScore(Score.STRIKE);
        assertTrue(frame.hasStrike());
    }

    @Test
    public void testHasStrikeWithInvalidStrike() {
        MiddleFrame frame = new MiddleFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.STRIKE);
        assertFalse(frame.hasStrike());
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