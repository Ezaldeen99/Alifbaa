package com.example.android.alifbaa;

/**
 * Created by lost on 27/12/2017.
 */

class Letter {
    private int letterId;
    private int letterImg;
    private int animalImg;
    private int wordImg;
    private String arabicReading;
    private String englishTranslation;
    private int letterSound;
    private int wordSound;

    public Letter(int letterId, int letterImg, int animalImg, int wordImg, String arabicReading, String englishTranslation, int letterSound, int wordSound) {
        this.letterId = letterId;
        this.letterImg = letterImg;
        this.animalImg = animalImg;
        this.wordImg = wordImg;
        this.arabicReading = arabicReading;
        this.englishTranslation = englishTranslation;
        this.letterSound = letterSound;
        this.wordSound = wordSound;
    }

    public Letter(int letterId, int letterImg) {
        this.letterId = letterId;
        this.letterImg = letterImg;
    }

    public int getLetterId() {
        return letterId;
    }

    public int getLetterImg() {
        return letterImg;
    }

    public int getAnimalImg() {
        return animalImg;
    }

    public int getWordImg() {
        return wordImg;
    }

    public String getArabicReading() {
        return arabicReading;
    }

    public String getEnglishTranslation() {
        return englishTranslation;
    }

    public int getLetterSound() {
        return letterSound;
    }

    public int getWordSound() {
        return wordSound;
    }

}
