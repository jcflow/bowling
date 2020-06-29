package com.juanchavezcornejo.bowling.core.frames;

public class StartFrame extends MiddleFrame {
    public int retrieveSum() {
        int sum = 0;
        if (hasStrike() && this.getNext() != null) {
            sum = 10 + this.getNext().retrieveNextScore(0).getValue()
                    + this.getNext().retrieveNextScore(1).getValue();
        } else if (hasSpare()) {
            sum = 10 + this.getNext().retrieveNextScore(0).getValue();
        } else {
            sum = this.firstRoll.getValue() + this.secondRoll.getValue()
                    + this.getNext().retrieveNextScore(0).getValue();
        }
        return sum;
    }

    @Override
    public void setPrevious(BowlingFrame previous) {
        throw new RuntimeException();
    }

    @Override
    public BowlingFrame getPrevious() {
        return null;
    }
}
