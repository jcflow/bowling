package com.juanchavezcornejo.bowling.core.frames;

import com.juanchavezcornejo.bowling.core.score.Score;

import java.util.ArrayList;
import java.util.List;

public class EndFrame implements BowlingFrame {
    public BowlingFrame previous;
    protected Score firstRoll;
    protected Score secondRoll;
    protected Score thirdRoll;

    public EndFrame() {
        this.previous = null;
        this.firstRoll = null;
        this.secondRoll = null;
        this.thirdRoll = null;
    }

    @Override
    public int retrieveSum() {
        if (this.previous == null || this.firstRoll == null || this.secondRoll == null || this.thirdRoll == null) {
            throw new RuntimeException();
        }
        int sum = 0;
        if (this.firstRoll == Score.STRIKE) {
            sum = this.previous.retrieveSum() + 10 + this.retrieveNextScore(1).getValue()
                    + this.retrieveNextScore(2).getValue();
        } if (this.secondRoll == Score.STRIKE) {
            sum = this.previous.retrieveSum() + 10 + this.retrieveNextScore(0).getValue()
                    + this.retrieveNextScore(2).getValue();
        } if (this.thirdRoll == Score.STRIKE) {
            sum = this.previous.retrieveSum() + 10 + this.retrieveNextScore(0).getValue()
                    + this.retrieveNextScore(1).getValue();
        } else if (this.firstRoll.getValue() + this.secondRoll.getValue() == 10) {
            sum = this.previous.retrieveSum() + 10 + this.thirdRoll.getValue();
        } else if (this.secondRoll.getValue() + this.thirdRoll.getValue() == 10) {
            sum = this.previous.retrieveSum() + 10 + this.firstRoll.getValue();
        } else {
            return this.previous.retrieveSum() + this.firstRoll.getValue() + this.secondRoll.getValue()
                    + this.thirdRoll.getValue();
        }
        return sum;
    }

    @Override
    public Score retrieveNextScore(int i) {
        Score score = null;
        if (i <= 0) {
            if (this.secondRoll != null && this.firstRoll != Score.NONE) {
                return this.firstRoll;
            }
            score = this.retrieveNextScore(i + 1);
        } else if (i == 1 && this.secondRoll != null && this.secondRoll != Score.NONE) {
            score = this.secondRoll;
        } else if (i >= 2 && this.thirdRoll != null && this.thirdRoll != Score.NONE) {
            score = this.thirdRoll;
        }
        if (score != null) {
            return score;
        }
        throw new RuntimeException();
    }

    @Override
    public void addScore(Score score) {
        if (score == null) {
            throw new RuntimeException();
        }
        if (this.firstRoll == null) {
            this.firstRoll = score;
        } else if (this.secondRoll == null) {
            this.secondRoll = score;
        } else if (this.thirdRoll == null) {
            this.thirdRoll = score;
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
        throw new RuntimeException();
    }

    @Override
    public BowlingFrame getNext() {
        return null;
    }

    @Override
    public boolean hasStrike() {
        return this.firstRoll == Score.STRIKE ||
                this.secondRoll == Score.STRIKE ||
                this.thirdRoll == Score.STRIKE;
    }

    @Override
    public boolean hasSpare() {
        return this.firstRoll.getValue() + this.secondRoll.getValue() == 10 ||
                this.secondRoll.getValue() + this.thirdRoll.getValue() == 10;
    }

    @Override
    public boolean canAddScore() {
        return this.firstRoll == null || this.secondRoll == null || this.thirdRoll == null;
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
            } else {
                scores.add(this.secondRoll);
            }
        }
        if (this.secondRoll != null && this.thirdRoll != null) {
            if (this.secondRoll != Score.STRIKE && this.secondRoll.getValue() + this.thirdRoll.getValue() == 10) {
                scores.add(Score.SPARE);
            } else {
                scores.add(this.thirdRoll);
            }
        }
        return scores;
    }

    @Override
    public int retrieveSize() {
        return 3;
    }
}
