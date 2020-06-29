package com.juanchavezcornejo.bowling.frames;

import com.juanchavezcornejo.bowling.score.Score;

import java.util.List;

public class MiddleFrame implements BowlingFrame {
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
}
