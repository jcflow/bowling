package com.juanchavezcornejo.bowling.core;

import com.juanchavezcornejo.bowling.core.frames.BowlingFrame;
import com.juanchavezcornejo.bowling.core.score.Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BowlingPlayer {
    private String name;
    private int frameListSize;
    private BowlingFrame currentFrame;

    public BowlingPlayer(String name, int frameListSize) {
        this.name = name;
        this.frameListSize = frameListSize;
        this.currentFrame = BowlingUtils.initFrameLine(frameListSize);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BowlingPlayer) {
            BowlingPlayer player = (BowlingPlayer) obj;
            return player.getName().equals(this.name);
        }
        return super.equals(obj);
    }

    public String getName() {
        return name;
    }

    public void addScore(Score score) {
        if (this.currentFrame.canAddScore()) {
            this.currentFrame.addScore(score);
        } else if (this.currentFrame.getNext() != null) {
            this.currentFrame = this.currentFrame.getNext();
            addScore(score);
        } else {
            throw new BowlingException("Could not add new score to this player.");
        }
    }

    public int retrieveFrameResult(int index) {
        BowlingFrame temp = this.currentFrame;
        int result = this.retrieveFrameResult(index, 0);
        this.currentFrame = temp;
        return result;
    }

    private int retrieveFrameResult(int index, int count) {
        if (index == (this.frameListSize - count - 1)) {
            return this.currentFrame.retrieveSum();
        }
        if (this.currentFrame.getPrevious() != null) {
            this.currentFrame = this.currentFrame.getPrevious();
            return this.retrieveFrameResult(index, count + 1);
        }
        throw new BowlingException("Could not retrieve frame result.");
    }

    public List<BowlingFrame> retrieveFrames() {
        BowlingFrame temp = this.currentFrame;
        BowlingFrame frame = this.currentFrame;
        List<BowlingFrame> frames = new ArrayList<>();
        while (frame != null) {
            frames.add(frame);
            frame = frame.getPrevious();
        }
        this.currentFrame = temp;
        Collections.reverse(frames);
        return frames;
    }
}
