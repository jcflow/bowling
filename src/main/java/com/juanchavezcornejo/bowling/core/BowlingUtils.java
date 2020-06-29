package com.juanchavezcornejo.bowling.core;

import com.juanchavezcornejo.bowling.core.frames.BowlingFrame;
import com.juanchavezcornejo.bowling.core.frames.EndFrame;
import com.juanchavezcornejo.bowling.core.frames.MiddleFrame;
import com.juanchavezcornejo.bowling.core.frames.StartFrame;

public class BowlingUtils {
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
