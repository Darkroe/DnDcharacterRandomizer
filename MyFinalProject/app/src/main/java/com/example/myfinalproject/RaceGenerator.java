package com.example.myfinalproject;

import java.util.Random;

public class RaceGenerator {

    private int rArrayLength;

    private String[] raceArray;

    private String[] randRaceArray;

    public RaceGenerator() {
        rArrayLength = 9;
        raceArray = new String[rArrayLength];

        fillRaceArray();
    }

    private void fillRaceArray() {
        raceArray[0] = "Dwarf";
        raceArray[1] = "Elf";
        raceArray[2] = "Halfling";
        raceArray[3] = "Human";
        raceArray[4] = "Dragonborn";
        raceArray[5] = "Gnome";
        raceArray[6] = "Half-Elf";
        raceArray[7] = "Half-Orc";
        raceArray[8] = "Tiefling";
    }

    public String getRaceName(int raceSelection) {
        return randRaceArray[raceSelection];
    }

    public void generateAllRaces(int numRandRaces) {
        randRaceArray = new String[numRandRaces];

        int raceSelector = 0;

        for (int i = 0; i < numRandRaces; i++) {
            raceSelector = new Random().nextInt(rArrayLength);
            randRaceArray[i] = raceArray[raceSelector];
        }
    }
}
