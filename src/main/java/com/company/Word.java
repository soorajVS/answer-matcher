package com.company;

import java.util.HashMap;
import java.util.Map;

public class Word {
    private static Map<String, String> singularToPluraLMap  = new HashMap<>();
    private static Map<String, String> pluralToSingularMap = new HashMap<>();

    static {
        singularToPluraLMap.put("aim", "aims");
        singularToPluraLMap.put("zebra", "zebras");
        singularToPluraLMap.put("horse", "horses");
        singularToPluraLMap.put("specie", "species");
        singularToPluraLMap.put("animal", "animals");
        singularToPluraLMap.put("equid", "equids");
        singularToPluraLMap.put("resemble", "resembles");
        singularToPluraLMap.put("population", "populations");

        for(Map.Entry<String, String> entry : singularToPluraLMap.entrySet()){
            pluralToSingularMap.put(entry.getValue(), entry.getKey());
        }

    }

    private String word;

    private Word(String word){
        this.word = word.toLowerCase();
    }

    public static Word buildWord(String word){
        if(word == null || word.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid Word");
        }
        return new Word(word);
    }

    public static Word getPluralOrSingularOf(Word word){
        Word returnVal = word;
        String wordString = word.toString();
        String plural = singularToPluraLMap.get(wordString);
        if(plural != null){
            returnVal = Word.buildWord(plural);
        }else {
            plural = pluralToSingularMap.get(wordString);
            if(plural != null) {
                returnVal = Word.buildWord(plural);
            }
        }
        return returnVal;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Word) {
            return word.equals(((Word)obj).word);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public String toString() {
        return word;
    }
}
