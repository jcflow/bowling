package com.juanchavezcornejo.bowling;

import com.juanchavezcornejo.bowling.core.BowlingGame;
import com.juanchavezcornejo.bowling.io.BowlingFileReader;
import com.juanchavezcornejo.bowling.io.BowlingFileWriter;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputPath = args[0];
        String outputPath = args[1];
        BowlingGame game = BowlingFileReader.readFile(inputPath);
        BowlingFileWriter.writeFile(outputPath, game);
    }
}
