package com.kata.automate.model;

public enum PivoteDirection {
    GAUCHE('G'), DROITE('D');

    private final char value;

    PivoteDirection(char value){
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }

    public static PivoteDirection valueOf(char value) {
        if(GAUCHE.getValue() == value)
            return GAUCHE;
        else  return DROITE;

    }
}
