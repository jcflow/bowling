package com.juanchavezcornejo.bowling.core.score;

public enum Score {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    STRIKE(10),
    FOUL(0),
    SPARE(10),
    NONE(0);

    private int value;

    Score(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
