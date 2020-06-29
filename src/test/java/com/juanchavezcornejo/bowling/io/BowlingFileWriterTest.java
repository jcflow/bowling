package com.juanchavezcornejo.bowling.io;

import com.juanchavezcornejo.bowling.core.BowlingGame;
import com.juanchavezcornejo.bowling.core.BowlingPlayer;
import com.juanchavezcornejo.bowling.core.score.Score;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingFileWriterTest {
    @Test
    void write() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/resources/file.output";
        BowlingGame game = new BowlingGame();
        game.addPlayer(new BowlingPlayer("Jeff", 10));
        game.addPlayer(new BowlingPlayer("John", 10));

        game.addScore("Jeff", Score.STRIKE);
        game.addScore("Jeff", Score.SEVEN);
        game.addScore("Jeff", Score.THREE);
        game.addScore("Jeff", Score.NINE);
        game.addScore("Jeff", Score.ZERO);
        game.addScore("Jeff", Score.STRIKE);
        game.addScore("Jeff", Score.ZERO);
        game.addScore("Jeff", Score.EIGHT);
        game.addScore("Jeff", Score.EIGHT);
        game.addScore("Jeff", Score.TWO);
        game.addScore("Jeff", Score.FOUL);
        game.addScore("Jeff", Score.SIX);
        game.addScore("Jeff", Score.STRIKE);
        game.addScore("Jeff", Score.STRIKE);
        game.addScore("Jeff", Score.STRIKE);
        game.addScore("Jeff", Score.EIGHT);
        game.addScore("Jeff", Score.ONE);

        game.addScore("John", Score.THREE);
        game.addScore("John", Score.SEVEN);
        game.addScore("John", Score.SIX);
        game.addScore("John", Score.THREE);
        game.addScore("John", Score.STRIKE);
        game.addScore("John", Score.EIGHT);
        game.addScore("John", Score.ONE);
        game.addScore("John", Score.STRIKE);
        game.addScore("John", Score.STRIKE);
        game.addScore("John", Score.NINE);
        game.addScore("John", Score.ZERO);
        game.addScore("John", Score.SEVEN);
        game.addScore("John", Score.THREE);
        game.addScore("John", Score.FOUR);
        game.addScore("John", Score.FOUR);
        game.addScore("John", Score.STRIKE);
        game.addScore("John", Score.NINE);
        game.addScore("John", Score.ZERO);
        BowlingFileWriter.writeFile(path, game);

        String[] expectedLines = {
                "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10",
                "Jeff",
                "Pinfalls\t\tX\t7\t/\t9\t0\t\tX\t0\t8\t8\t/\tF\t6\t\tX\t\tX\tX\t8\t1",
                "Score\t\t20\t\t39\t\t48\t\t66\t\t74\t\t84\t\t90\t\t120\t\t148\t\t167",
                "John",
                "Pinfalls\t3\t/\t6\t3\t\tX\t8\t1\t\tX\t\tX\t9\t0\t7\t/\t4\t4\tX\t9\t0",
                "Score\t\t16\t\t25\t\t44\t\t53\t\t82\t\t101\t\t110\t\t124\t\t132\t\t151"
        };
        File outputFile = new File(path);
        List<String> lines = Files.readAllLines(outputFile.toPath(), Charset.defaultCharset());
        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i], lines.get(i));
        }
        outputFile.delete();
    }
}
