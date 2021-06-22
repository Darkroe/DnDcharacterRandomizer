package com.example.myfinalproject;

import java.util.Random;

public class NameGenerator {

    private int nameMinLength;
    private int nameMaxLength;

    private int alphabetLength;
    private int vowelCount;

    //TASK: Create character lists of letters to be used when making a name
    private char[] upperCaseLetters;
    private char[] lowerCaseLetters;

    private char[] vowelLetters;
    private char[] nonVowelLetters;

    //TASK: Create an empty String list to store generated names
    private String[] namesArray;

    //TASK: Create arraySelector variables
    private int selectUpperCase;
    private int selectLowerCase;
    private int selectVowels;
    private int selectNonVowels;

    public NameGenerator() {
        nameMinLength = 0;
        nameMaxLength = 0;

        alphabetLength = 26;
        vowelCount = 6;

        selectUpperCase = 1;
        selectLowerCase = 2;
        selectVowels = 3;
        selectNonVowels = 4;

        upperCaseLetters = new char[alphabetLength];
        lowerCaseLetters = new char[alphabetLength];

        vowelLetters = new char[vowelCount];
        nonVowelLetters = new char[alphabetLength - vowelCount];

        fillAlphabetArray(selectUpperCase);
        fillAlphabetArray(selectLowerCase);
        fillAlphabetArray(selectVowels);
        fillAlphabetArray(selectNonVowels);
    }

    public void setMinNameLength(int minLength) {
        nameMinLength = minLength;
    }

    public void setMaxNameLength(int maxLength) {
        nameMaxLength = maxLength;
    }

    public String getName(int nameSelector) {
        String nameToGet = namesArray[nameSelector];
        return nameToGet;
    }

    private void fillAlphabetArray(int arraySelector) {
        //TASK: Select which array to fill based on the arraySelector integer value
        //arraySelector = 1 --> fill upperCaseLetters
        //arraySelector = 2 --> fill lowerCaseLetters
        //arraySelector = 3 --> fill vowelLetters
        //arraySelector = 4 --> fill nonVowelLetters

        //TASK: create count variable to use for some loops
        int count = 0;

        if (arraySelector == 1) {
            for (char letter = 'A'; letter <= 'Z'; letter++) {
                upperCaseLetters[letter - 'A'] = letter;
            }
        }
        else if (arraySelector == 2) {
            for (char letter = 'a'; letter <= 'z'; letter++) {
                lowerCaseLetters[letter - 'a'] = letter;
            }
        }
        else if (arraySelector == 3) {
            count = 0;
            for (char letter = 'a'; letter <= 'z'; letter++) {
                if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y') {
                    vowelLetters[count] = letter;
                    count++;
                }
            }
        }
        else if (arraySelector == 4) {
            count = 0;
            for (char letter = 'a'; letter <= 'z'; letter++) {
                if(letter != 'a' && letter != 'e' && letter != 'i' && letter != 'o' && letter != 'u' && letter != 'y') {
                    nonVowelLetters[count] = letter;
                    count++;
                }
            }
        }
    }

    public void generateAllNames(int numberOfNames) {
        namesArray = new String[numberOfNames];

        int firstNameLength = 0;
        int lastNameLength = 0;

        String firstName = "";
        String lastName = "";

        for (int nameNum = 0; nameNum < numberOfNames; nameNum++) {
            firstNameLength = new Random().nextInt(nameMaxLength) + 1;
            if (firstNameLength < nameMinLength) {
                firstNameLength = nameMinLength;
            }

            lastNameLength = new Random().nextInt(nameMaxLength) + 1;
            if (lastNameLength < nameMinLength) {
                lastNameLength = nameMinLength;
            }

            firstName = generateOneFullName(firstNameLength);
            lastName = generateOneFullName(lastNameLength);

            namesArray[nameNum] = firstName + " " + lastName;
        }
    }

    private String generateOneFullName(int nameLength) {
        String nameToReturn = "";

        int selectorNum = 0;
        int arraySelector = 0;

        for (int letterPosition = 0; letterPosition < nameLength; letterPosition++) {
            selectorNum = new Random().nextInt(1) + 1;
            arraySelector = new Random().nextInt(2) + 2;

            if (letterPosition == 0) {
                nameToReturn = letterTypeSelector(selectorNum, selectUpperCase, arraySelector);
            }
            else if (letterPosition % 2 == 1) {
                nameToReturn = nameToReturn + letterTypeSelector(selectorNum, selectVowels, arraySelector);
            }
            else if (letterPosition % 2 == 0) {
                nameToReturn = nameToReturn + letterTypeSelector(selectorNum, selectLowerCase, arraySelector);
            }
        }
        return nameToReturn;
    }

    private String letterTypeSelector(int selectorNum, int arrayImport, int arraySelector) {
        char[] charList = arraySelection(arrayImport);

        int randomArrayElement = new Random().nextInt(charList.length);

        if (selectorNum == 1) {
            return String.valueOf(charList[randomArrayElement]);
        }
        else if (selectorNum == 2) {
            char firstLetter = charList[randomArrayElement];
            return generateDoubleLetter(firstLetter, arraySelector);
        }

        return "00";
    }

    private String generateDoubleLetter(char firstLetter, int arraySelector) {
        String[] doubleLetterList;

        char[] charList = arraySelection(arraySelector);

        int randomArrayElement = new Random().nextInt(charList.length);

        doubleLetterList = generateDoubleLetterArray(firstLetter, charList);

        return doubleLetterList[randomArrayElement];
    }

    private String[] generateDoubleLetterArray(char firstLetter, char[] selectedArray) {
        String[] doubleLetterList = new String[alphabetLength];
        String doubleLetter;

        for (int arrayCount = 0; arrayCount < selectedArray.length; arrayCount++) {
            doubleLetter = String.valueOf(firstLetter + selectedArray[arrayCount]);
            doubleLetterList[arrayCount] = doubleLetter;
        }

        return doubleLetterList;
    }

    private char[] arraySelection(int arraySelector) {
        if (arraySelector == 1) {
            return upperCaseLetters;
        }
        else if (arraySelector == 2) {
            return lowerCaseLetters;
        }
        else if (arraySelector == 3) {
            return vowelLetters;
        }
        else if (arraySelector == 4) {
            return nonVowelLetters;
        }

        return new char[alphabetLength];
    }

}
