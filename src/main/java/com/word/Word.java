package com.word;

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

}
