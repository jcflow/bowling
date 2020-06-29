package com.juanchavezcornejo.bowling.io;

import com.juanchavezcornejo.bowling.core.BowlingGame;
import com.juanchavezcornejo.bowling.core.BowlingPlayer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BowlingFileReaderTest {

    private String path1;
    private String path2;

    @BeforeAll
    public void init() {
        this.path1 = System.getProperty("user.dir") + "/src/test/java/resources/file1.bowling";
        this.path2 = System.getProperty("user.dir") + "/src/test/java/resources/file2.bowling";
    }

    @Test
    void testReadFile1VerifyPlayers() {
        BowlingGame game = BowlingFileReader.readFile(this.path1);

        assertEquals(2, game.getPlayers().size());
        assertEquals("Jeff", game.getPlayers().get(0).getName());
        assertEquals("John", game.getPlayers().get(1).getName());
    }

    @Test
    void testReadFile1VerifyPlayersNames() {
        BowlingGame game = BowlingFileReader.readFile(this.path1);

        assertTrue(game.hasPlayerWithName("Jeff"));
        assertTrue(game.hasPlayerWithName("John"));
    }

    @Test
    void testReadFile1RetrieveResult() {
        BowlingGame game = BowlingFileReader.readFile(this.path1);

        BowlingPlayer player1 = game.getPlayerWithName("Jeff");
        BowlingPlayer player2 = game.getPlayerWithName("John");

        int[] player1Results = {20, 39, 48, 66, 74, 84, 90, 120, 148, 167};
        int[] player2Results = {16, 25, 44, 53, 82, 101, 110, 124, 132, 151};

        for (int i = 0; i < 10; i++) {
            assertEquals(player1Results[i], player1.retrieveFrameResult(i));
            assertEquals(player2Results[i], player2.retrieveFrameResult(i));
        }
    }

    @Test
    void testReadFile2VerifyPlayers() {
        BowlingGame game = BowlingFileReader.readFile(this.path2);

        assertEquals(1, game.getPlayers().size());
        assertEquals("Carl", game.getPlayers().get(0).getName());
    }

    @Test
    void testReadFile2VerifyPlayersNames() {
        BowlingGame game = BowlingFileReader.readFile(this.path2);

        assertTrue(game.hasPlayerWithName("Carl"));
    }

    @Test
    void testReadFile2RetrieveResult() {
        BowlingGame game = BowlingFileReader.readFile(this.path2);

        BowlingPlayer player1 = game.getPlayerWithName("Carl");

        int[] player1Results = {30, 60, 90, 120, 150, 180, 210, 240, 270, 300};

        for (int i = 0; i < 10; i++) {
            assertEquals(player1Results[i], player1.retrieveFrameResult(i));
        }
    }
}
