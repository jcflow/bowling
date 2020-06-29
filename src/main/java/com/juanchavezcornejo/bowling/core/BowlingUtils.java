package com.juanchavezcornejo.bowling.core;

import com.juanchavezcornejo.bowling.core.frames.BowlingFrame;
import com.juanchavezcornejo.bowling.core.frames.EndFrame;
import com.juanchavezcornejo.bowling.core.frames.MiddleFrame;
import com.juanchavezcornejo.bowling.core.frames.StartFrame;
import com.juanchavezcornejo.bowling.core.score.Score;

public class BowlingUtils {
    public static boolean isSpare(Score score1, Score score2) {
        if (score1 == null || score2 == null || score1 == Score.NONE || score2 == Score.NONE || score1 == Score.STRIKE
                ||score2 == Score.STRIKE) {
            return false;
        }
        return score1.getValue() + score2.getValue() == 10;
    }

    public static BowlingFrame initFrameLine(int frameListSize) {
        if (frameListSize < 3) {
            throw new RuntimeException();
        }
        BowlingFrame currentFrame = null;
        for (int c = 0; c < frameListSize; c++) {
            BowlingFrame frame;
            if (c <= 0) {
                frame = new EndFrame();
            } else if (c >= frameListSize - 1) {
                frame = new StartFrame();
            } else {
                frame = new MiddleFrame();
            }
            if (currentFrame != null) {
                frame.setNext(currentFrame);
                currentFrame.setPrevious(frame);
            }
            currentFrame = frame;
        }
        return currentFrame;
    }
}
