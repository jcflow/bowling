package com.juanchavezcornejo.bowling.frames;

import com.juanchavezcornejo.bowling.score.Score;

import java.util.List;

public class StartFrame implements BowlingFrame {

    @Override
    public void setNext(BowlingFrame mock) {
    }

    @Override
    public BowlingFrame getNext() {
        return null;
    }

    public void addScore(Score one) {
    }

    @Override
    public void setPrevious(BowlingFrame previous) {

    }

    @Override
    public BowlingFrame getPrevious() {
        return null;
    }

    @Override
    public int retrieveSum() {
        return 0;
    }

    @Override
    public Score retrieveNextScore(int i) {
        return null;
    }

    @Override
    public List<Score> retrieveScoreList() {
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
    public int retrieveSize() {
        return 0;
    }
}
