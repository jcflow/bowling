package com.juanchavezcornejo.bowling.core;

import com.juanchavezcornejo.bowling.core.frames.BowlingFrame;
import com.juanchavezcornejo.bowling.core.frames.EndFrame;
import com.juanchavezcornejo.bowling.core.frames.MiddleFrame;
import com.juanchavezcornejo.bowling.core.frames.StartFrame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BowlingUtilsTest {
    @Test
    public void testWithValidArgument() {
        BowlingFrame frame = BowlingUtils.initFrameLine(5);
        assertTrue(frame instanceof StartFrame);
        assertTrue(frame.getNext() instanceof MiddleFrame);
        assertTrue(frame.getNext().getNext() instanceof MiddleFrame);
        assertTrue(frame.getNext().getNext().getNext() instanceof MiddleFrame);
        assertTrue(frame.getNext().getNext().getNext() instanceof MiddleFrame);
        assertTrue(frame.getNext().getNext().getNext().getNext() instanceof EndFrame);
    }

    @Test
    public void testWithValidMinimumSize() {
        BowlingFrame frame = BowlingUtils.initFrameLine(3);
        assertTrue(frame instanceof StartFrame);
        assertTrue(frame.getNext() instanceof MiddleFrame);
        assertTrue(frame.getNext().getNext() instanceof EndFrame);
    }

    @Test
    public void testWithInvalidSize() {
        assertThrows(BowlingException.class, () -> {
            BowlingFrame frame = BowlingUtils.initFrameLine(1);
        });
    }
}
