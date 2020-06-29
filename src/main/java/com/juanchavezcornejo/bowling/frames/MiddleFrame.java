package com.juanchavezcornejo.bowling.frames;

import com.juanchavezcornejo.bowling.score.Score;

import java.util.ArrayList;
import java.util.List;

public class MiddleFrame implements BowlingFrame {
    private BowlingFrame previous;
    private BowlingFrame next;
    protected Score firstRoll;
    protected Score secondRoll;

    public MiddleFrame() {
        this.previous = null;
        this.next = null;
        this.firstRoll = null;
        this.secondRoll = null;
    }

    @Override
    public int retrieveSum() {
        int sum;
        if (hasStrike()) {
            sum = this.previous.retrieveSum() + 10 + this.next.retrieveNextScore(0).getValue()
                    + this.next.retrieveNextScore(1).getValue();
        } else if (hasSpare()) {
            sum = this.previous.retrieveSum() + 10 + this.next.retrieveNextScore(0).getValue();
        } else {
            sum = this.previous.retrieveSum() + this.firstRoll.getValue() + this.secondRoll.getValue();
        }
        return sum;
    }

    @Override
    public Score retrieveNextScore(int i) {
        Score score;
        if (i <= 0) {
            if (this.firstRoll != Score.NONE) {
                return this.firstRoll;
            }
            score = this.retrieveNextScore(i + 1);
        } else if (i == 1 && this.secondRoll != null && this.secondRoll != Score.NONE) {
            score = this.secondRoll;
        } else {
            score = this.getNext().retrieveNextScore(i - 1);
        }
        return score;
    }

    @Override
    public void addScore(Score score) {
        if (score == null) {
            throw new RuntimeException();
        }
        if (this.firstRoll == null) {
            if (score == Score.STRIKE) {
                this.firstRoll = score;
                this.secondRoll = Score.NONE;
            } else {
                this.firstRoll = score;
            }
        } else if (this.secondRoll == null) {
            this.secondRoll = score;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void setPrevious(BowlingFrame previous) {
        this.previous = previous;
    }

    @Override
    public BowlingFrame getPrevious() {
        return this.previous;
    }

    @Override
    public void setNext(BowlingFrame next) {
        this.next = next;
    }

    @Override
    public BowlingFrame getNext() {
        return this.next;
    }

    @Override
    public boolean hasStrike() {
        return this.firstRoll == Score.STRIKE;
    }

    @Override
    public boolean hasSpare() {
        return this.firstRoll.getValue() + this.secondRoll.getValue() == 10;
    }

    @Override
    public boolean canAddScore() {
        if (this.firstRoll == Score.STRIKE) {
            return false;
        }
        return this.firstRoll == null || this.secondRoll == null;
    }

    @Override
    public List<Score> retrieveScoreList() {
        List<Score> scores = new ArrayList<>();
        if (this.firstRoll != null) {
            scores.add(this.firstRoll);
        }
        if (this.firstRoll != null && this.secondRoll != null) {
            if (this.firstRoll != Score.STRIKE && this.firstRoll.getValue() + this.secondRoll.getValue() == 10) {
                scores.add(Score.SPARE);
            } else if (this.secondRoll != Score.NONE) {
                scores.add(this.secondRoll);
            }
        }
        return scores;
    }

    @Override
    public int retrieveSize() {
        return 2;
    }
}
