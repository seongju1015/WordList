package com.wordList;

public class Word {private int level;
    private String word;
    private String meaning;

    public Word(int level, String word, String meaning){

        this.level = level;
        this.word = word;
        this.meaning = meaning;

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setWord(String word) {
        this.word = word;
    }
    @Override
    public String toString() {
        String starLevel = "";
        if(level == 1){
            starLevel = "*";
        }
        if(level == 2){
            starLevel = "**";
        }
        if(level == 3){
            starLevel = "***";
        }

        String str = String.format("%-3s",starLevel + String.format("%15s",word) + "  " + meaning);
        return str;
    }

}
