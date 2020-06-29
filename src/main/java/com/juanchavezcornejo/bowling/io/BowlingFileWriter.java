package com.juanchavezcornejo.bowling.io;

import com.juanchavezcornejo.bowling.core.BowlingGame;
import com.juanchavezcornejo.bowling.core.BowlingPlayer;
import com.juanchavezcornejo.bowling.core.frames.BowlingFrame;
import com.juanchavezcornejo.bowling.core.score.Score;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BowlingFileWriter {
    private static final char STRIKE_SYMBOL = 'X';
    private static final char FOUL_SYMBOL = 'F';
    private static final char SPARE_SYMBOL = '/';
    private static final String SEPARATOR = "\t";

    public static void writeFile(String fileName, BowlingGame game) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(BowlingFileWriter.createHeaderLine());
        game.getPlayers().forEach(player -> {
            printWriter.println(player.getName());
            printWriter.println(BowlingFileWriter.createPinfallsLine(player));
            printWriter.println(BowlingFileWriter.createScoreLine(player));
        });
        printWriter.close();
    }

    private static String createHeaderLine() {
        StringBuilder builder = new StringBuilder();
        builder.append("Frame");
        builder.append(SEPARATOR + SEPARATOR);
        for (int i = 1; i <= BowlingGame.FRAMES_SIZE; i++) {
            builder.append(i);
            if (i < BowlingGame.FRAMES_SIZE) {
                builder.append(SEPARATOR + SEPARATOR);
            }
        }
        return builder.toString();
    }

    private static String createPinfallsLine(BowlingPlayer player) {
        StringBuilder builder = new StringBuilder();
        builder.append("Pinfalls");
        builder.append(SEPARATOR);
        List<BowlingFrame> frames = player.retrieveFrames();
        for (int i = 0; i < frames.size(); i++) {
            BowlingFrame frame = frames.get(i);
            boolean isLastFrame = i >= frames.size() - 1;
            builder.append(BowlingFileWriter.retrieveFrameString(frame, isLastFrame));
        }
        return builder.toString();
    }

    private static String retrieveFrameString(BowlingFrame frame, boolean isLastFrame) {
        StringBuilder builder = new StringBuilder();
        List<Score> scores = frame.retrieveScoreList();
        for (int i = 0; i < scores.size(); i++) {
            Score score = scores.get(i);
            if (score == Score.STRIKE) {
                builder.append(STRIKE_SYMBOL);
            } else if (score == Score.FOUL) {
                builder.append(FOUL_SYMBOL);
            } else if (score == Score.SPARE) {
                builder.append(SPARE_SYMBOL);
            } else if (score != Score.NONE) {
                builder.append(score.getValue());
            }
            if (!(isLastFrame && i >= scores.size() - 1)) {
                builder.append(SEPARATOR);
            }
        }
        for (int i = 0; i < (frame.retrieveSize() - scores.size()); i++) {
            builder.insert(0, SEPARATOR);
        }
        return builder.toString();
    }

    private static String createScoreLine(BowlingPlayer player) {
        StringBuilder builder = new StringBuilder();
        builder.append("Score");
        builder.append(SEPARATOR + SEPARATOR);
        for (int i = 0; i < BowlingGame.FRAMES_SIZE; i++) {
            builder.append(player.retrieveFrameResult(i));
            if (i < BowlingGame.FRAMES_SIZE -1) {
                builder.append(SEPARATOR + SEPARATOR);
            }
        }
        return builder.toString();
    }
}
