package com.juanchavezcornejo.bowling.io;

import com.juanchavezcornejo.bowling.core.BowlingGame;
import com.juanchavezcornejo.bowling.core.BowlingPlayer;
import com.juanchavezcornejo.bowling.core.score.Score;
import com.juanchavezcornejo.bowling.core.score.ScoreFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class BowlingFileReader {
    public static BowlingGame readFile(String fileName) {
        BowlingGame bowlingGame = new BowlingGame();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach((line) -> {
                String name = line.split("\\s+")[0];
                String stringScore = line.split("\\s+")[1];
                Score score = ScoreFactory.createScore(stringScore);
                BowlingPlayer player;
                if (!bowlingGame.hasPlayerWithName(name)) {
                    player = new BowlingPlayer(name, BowlingGame.FRAMES_SIZE);
                    bowlingGame.addPlayer(player);
                }
                bowlingGame.addScore(name, score);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bowlingGame;
    }
}
