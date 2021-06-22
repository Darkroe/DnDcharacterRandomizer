package com.example.myfinalproject;

import java.util.Random;

public class AbilityScoreGenerator {

    private int asArrayLength;
    private int abilityScoreLimit;

    private int[] abilityScoreArray;

    public AbilityScoreGenerator() {
        asArrayLength = 6;
        abilityScoreLimit = 20;
    }

    public int getAbilityScore(int abScoreSelection) {
        return abilityScoreArray[abScoreSelection];
    }

    public void generateAllAbilityScores(int numRandAbilityScores) {
        abilityScoreArray = new int[numRandAbilityScores];

        int abilityScoreSelector = 0;

        for (int i = 0; i < numRandAbilityScores; i++) {
            abilityScoreSelector = new Random().nextInt(abilityScoreLimit) + 1;
            abilityScoreArray[i] = abilityScoreSelector;
        }
    }
}
