package com.juanchavezcornejo.bowling;

import com.juanchavezcornejo.bowling.frames.BowlingFrame;
import com.juanchavezcornejo.bowling.frames.EndFrame;
import com.juanchavezcornejo.bowling.frames.MiddleFrame;
import com.juanchavezcornejo.bowling.score.Score;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EndFrameTest {
    @Test
    void testSumWithNoSpareNoStrike() {
        EndFrame frame = new EndFrame();
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
        frame.addScore(Score.THREE);
        assertEquals(6, frame.retrieveSum());
    }

    @Test
    void testSumWithStrikeAndSpare1() {
        EndFrame frame = new EndFrame();
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
        frame.addScore(Score.NINE);
        frame.addScore(Score.STRIKE);
        assertEquals(20, frame.retrieveSum());
    }

    @Test
    void testSumWithStrikeAndSpare2() {
        EndFrame frame = new EndFrame();
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
        frame.addScore(Score.STRIKE);
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);
        assertEquals(20, frame.retrieveSum());
    }

    @Test
    void testSumWithThreeStrikes() {
        EndFrame frame = new EndFrame();
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
        frame.addScore(Score.STRIKE);
        frame.addScore(Score.STRIKE);
        frame.addScore(Score.STRIKE);
        assertEquals(30, frame.retrieveSum());
    }

    @Test
    void testRetrieveScoreListWithNoSpareNoStrike() {
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
    void testRetrieveScoreListWithStrike() {
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
    void testRetrieveScoreListWithSpare() {
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
    void testHasStrikeWithValidSpare1() {
        EndFrame frame = new EndFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.NINE);
        frame.addScore(Score.ZERO);
        assertTrue(frame.hasSpare());
    }

    @Test
    void testHasStrikeWithValidSpare2() {
        EndFrame frame = new EndFrame();
        frame.addScore(Score.STRIKE);
        frame.addScore(Score.NINE);
        frame.addScore(Score.ONE);
        assertTrue(frame.hasSpare());
    }

    @Test
    void testHasStrikeWithNoSpare() {
        EndFrame frame = new EndFrame();
        frame.addScore(Score.ONE);
        frame.addScore(Score.TWO);
        frame.addScore(Score.THREE);
        assertFalse(frame.hasSpare());
    }

    @Test
    void endframe8() {
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
    void testRetrieveSize() {
        EndFrame frame = new EndFrame();
        assertEquals(3, frame.retrieveSize());
    }
}
