package com.juanchavezcornejo.bowling.core.frames;

import com.juanchavezcornejo.bowling.core.BowlingException;
import com.juanchavezcornejo.bowling.core.BowlingUtils;
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
            throw new BowlingException("Previous frame or not all rolls are set.");
        }
        int sum = this.previous.retrieveSum();
        if (this.firstRoll == Score.STRIKE) {
            sum += this.firstRoll.getValue() + this.retrieveNextScore(1).getValue()
                    + this.retrieveNextScore(2).getValue();
        } else if (this.secondRoll == Score.STRIKE) {
            sum += this.secondRoll.getValue() + this.retrieveNextScore(0).getValue()
                    + this.retrieveNextScore(2).getValue();
        } else if (this.thirdRoll == Score.STRIKE) {
            sum += this.thirdRoll.getValue() + this.retrieveNextScore(0).getValue()
                    + this.retrieveNextScore(1).getValue();
        } else if (BowlingUtils.isSpare(this.firstRoll, this.secondRoll)) {
            sum +=  Score.SPARE.getValue() + this.thirdRoll.getValue();
        } else if (BowlingUtils.isSpare(this.secondRoll, this.thirdRoll)) {
            sum += Score.SPARE.getValue() + this.firstRoll.getValue();
        } else {
            sum += this.firstRoll.getValue() + this.secondRoll.getValue() + this.thirdRoll.getValue();
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
        throw new BowlingException("There is next score.");
    }

    @Override
    public void addScore(Score score) {
        if (score == null) {
            throw new BowlingException("Score argument is null.");
        }
        if (this.firstRoll == null) {
            this.firstRoll = score;
        } else if (this.secondRoll == null) {
            this.secondRoll = score;
        } else if (this.thirdRoll == null) {
            this.thirdRoll = score;
        } else {
            throw new BowlingException("No more scores permitted in the frame.");
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
        throw new BowlingException("End frame should not have a next reference.");
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
        return BowlingUtils.isSpare(this.firstRoll, this.secondRoll) ||
                BowlingUtils.isSpare(this.secondRoll, this.thirdRoll);
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
            if (BowlingUtils.isSpare(this.firstRoll, this.secondRoll)) {
                scores.add(Score.SPARE);
            } else {
                scores.add(this.secondRoll);
            }
        }
        if (BowlingUtils.isSpare(this.secondRoll, this.thirdRoll)) {
            scores.add(Score.SPARE);
        } else {
            scores.add(this.thirdRoll);
        }
        return scores;
    }

    @Override
    public int retrieveSize() {
        return 3;
    }
}
