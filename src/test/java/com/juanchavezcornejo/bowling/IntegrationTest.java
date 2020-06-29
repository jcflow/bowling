package com.juanchavezcornejo.bowling;

import com.juanchavezcornejo.bowling.core.BowlingGame;
import com.juanchavezcornejo.bowling.io.BowlingFileReader;
import com.juanchavezcornejo.bowling.io.BowlingFileWriter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    @Test
    void testReadAndWriteFile1() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/resources/file1.bowling";
        BowlingGame game = BowlingFileReader.readFile(path);

        String output = System.getProperty("user.dir") + "/src/test/java/resources/file.output";
        BowlingFileWriter.writeFile(output, game);
        String[] expectedLines = {
                "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10",
                "Jeff",
                "Pinfalls\t\tX\t7\t/\t9\t0\t\tX\t0\t8\t8\t/\tF\t6\t\tX\t\tX\tX\t8\t1",
                "Score\t\t20\t\t39\t\t48\t\t66\t\t74\t\t84\t\t90\t\t120\t\t148\t\t167",
                "John",
                "Pinfalls\t3\t/\t6\t3\t\tX\t8\t1\t\tX\t\tX\t9\t0\t7\t/\t4\t4\tX\t9\t0",
                "Score\t\t16\t\t25\t\t44\t\t53\t\t82\t\t101\t\t110\t\t124\t\t132\t\t151"
        };
        File outputFile = new File(output);
        List<String> lines = Files.readAllLines(outputFile.toPath(), Charset.defaultCharset());
        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i], lines.get(i));
        }
        outputFile.delete();
    }

    @Test
    void testReadAndWriteFile2() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/resources/file2.bowling";
        BowlingGame game = BowlingFileReader.readFile(path);

        String output = System.getProperty("user.dir") + "/src/test/java/resources/file.output";
        BowlingFileWriter.writeFile(output, game);
        String[] expectedLines = {
                "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10",
                "Carl",
                "Pinfalls\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\tX\tX\tX",
                "Score\t\t30\t\t60\t\t90\t\t120\t\t150\t\t180\t\t210\t\t240\t\t270\t\t300"
        };
        File outputFile = new File(output);
        List<String> lines = Files.readAllLines(outputFile.toPath(), Charset.defaultCharset());
        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i], lines.get(i));
        }
        outputFile.delete();
    }

    @Test
    void testReadAndWriteFile3() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/resources/file3.bowling";
        BowlingGame game = BowlingFileReader.readFile(path);

        String output = System.getProperty("user.dir") + "/src/test/java/resources/file.output";
        BowlingFileWriter.writeFile(output, game);
        String[] expectedLines = {
                "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10",
                "Carl",
                "Pinfalls\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0",
                "Score\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0"
        };
        File outputFile = new File(output);
        List<String> lines = Files.readAllLines(outputFile.toPath(), Charset.defaultCharset());
        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i], lines.get(i));
        }
        outputFile.delete();
    }

    @Test
    void testReadAndWriteFile4() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/resources/file4.bowling";
        BowlingGame game = BowlingFileReader.readFile(path);

        String output = System.getProperty("user.dir") + "/src/test/java/resources/file.output";
        BowlingFileWriter.writeFile(output, game);
        String[] expectedLines = {
                "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10",
                "Carl",
                "Pinfalls\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF",
                "Score\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0"
        };
        File outputFile = new File(output);
        List<String> lines = Files.readAllLines(outputFile.toPath(), Charset.defaultCharset());
        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i], lines.get(i));
        }
        outputFile.delete();
    }
}
