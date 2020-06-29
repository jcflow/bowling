package com.juanchavezcornejo.bowling.core.score;

import com.juanchavezcornejo.bowling.core.BowlingException;

public class ScoreFactory {
    public static Score createScore(String characters) {
        switch (characters) {
            case "0":
                return Score.ZERO;
            case "1":
                return Score.ONE;
            case "2":
                return Score.TWO;
            case "3":
                return Score.THREE;
            case "4":
                return Score.FOUR;
            case "5":
                return Score.FIVE;
            case "6":
                return Score.SIX;
            case "7":
                return Score.SEVEN;
            case "8":
                return Score.EIGHT;
            case "9":
                return Score.NINE;
            case "10":
                return Score.STRIKE;
            case "F":
                return Score.FOUL;
            default:
                throw new BowlingException("Invalid string score argument.");
        }
    }
}
