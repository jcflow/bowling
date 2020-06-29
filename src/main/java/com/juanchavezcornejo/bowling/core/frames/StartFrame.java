package com.juanchavezcornejo.bowling.core.frames;

import com.juanchavezcornejo.bowling.core.BowlingException;
import com.juanchavezcornejo.bowling.core.score.Score;

public class StartFrame extends MiddleFrame {
    public int retrieveSum() {
        if (this.next == null || this.firstRoll == null || this.secondRoll == null) {
            throw new BowlingException("Next frame or not all rolls are set.");
        }
        int sum;
        if (hasStrike()) {
            sum = this.firstRoll.getValue() + this.getNext().retrieveNextScore(0).getValue()
                    + this.getNext().retrieveNextScore(1).getValue();
        } else if (hasSpare()) {
            sum = Score.SPARE.getValue() + this.getNext().retrieveNextScore(0).getValue();
        } else {
            sum = this.firstRoll.getValue() + this.secondRoll.getValue()
                    + this.getNext().retrieveNextScore(0).getValue();
        }
        return sum;
    }

    @Override
    public void setPrevious(BowlingFrame previous) {
        throw new BowlingException("Start frame should not have a previous reference.");
    }

    @Override
    public BowlingFrame getPrevious() {
        return null;
    }
}
