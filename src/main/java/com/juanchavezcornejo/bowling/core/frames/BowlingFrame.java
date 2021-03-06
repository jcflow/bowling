package com.juanchavezcornejo.bowling.core.frames;

import com.juanchavezcornejo.bowling.core.score.Score;

import java.util.List;

public interface BowlingFrame {
    int retrieveSum();

    Score retrieveNextScore(int i);

    void addScore(Score score);

    void setPrevious(BowlingFrame previous);

    BowlingFrame getPrevious();

    void setNext(BowlingFrame next);

    BowlingFrame getNext();

    boolean hasStrike();

    boolean hasSpare();

    boolean canAddScore();

    List<Score> retrieveScoreList();

    int retrieveSize();
}
