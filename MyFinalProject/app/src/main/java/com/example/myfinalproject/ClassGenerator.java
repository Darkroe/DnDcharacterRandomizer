package com.example.myfinalproject;

import java.util.Random;

public class ClassGenerator {

    private int cArrayLength;

    private String[] classArray;

    private String[] randClassArray;

    public ClassGenerator() {
        cArrayLength = 12;
        classArray = new String[cArrayLength];

        fillClassArray();
    }

    private void fillClassArray() {
        classArray[0] = "Barbarian";
        classArray[1] = "Bard";
        classArray[2] = "Cleric";
        classArray[3] = "Druid";
        classArray[4] = "Fighter";
        classArray[5] = "Monk";
        classArray[6] = "Paladin";
        classArray[7] = "Ranger";
        classArray[8] = "Rogue";
        classArray[9] = "Sorcerer";
        classArray[10] = "Warlock";
        classArray[11] = "Wizard";
    }

    public String getClassName(int classSelection) {
        return randClassArray[classSelection];
    }

    public void generateAllClasses(int numRandClasses) {
        randClassArray = new String[numRandClasses];

        int classSelector = 0;

        for (int i = 0; i < numRandClasses; i++) {
            classSelector = new Random().nextInt(cArrayLength);
            randClassArray[i] = classArray[classSelector];
        }
    }
}
