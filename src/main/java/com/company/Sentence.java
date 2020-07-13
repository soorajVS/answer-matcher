package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sentence {

    private String sentence;

    static String sentenceSplitRegex = "[,\\s;()]";
    static Set<String> auxillaryWords = new HashSet<>();

    static {
        auxillaryWords.add("has");
        auxillaryWords.add("have");
        auxillaryWords.add("had");
        auxillaryWords.add("is");
        auxillaryWords.add("are");
        auxillaryWords.add("were");
        auxillaryWords.add("was");
        auxillaryWords.add("you");
        auxillaryWords.add("i");
        auxillaryWords.add("they");
        auxillaryWords.add("him");
        auxillaryWords.add("her");
        auxillaryWords.add("them");
        auxillaryWords.add("the");
        auxillaryWords.add("of");
        auxillaryWords.add("that");
        auxillaryWords.add("this");
    }

    protected Sentence(String sentence) {
        this.sentence = sentence;
    }

    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        String[] wordStings = sentence.split(sentenceSplitRegex);
        for (String wordString : wordStings) {
            if (isValidWord(wordString)) {
                Word word = Word.buildWord(wordString);
                words.add(word);
            }
        }
        return words;
    }

    protected Boolean isValidWord(String wordString){
        return !wordString.isEmpty() &&
                !auxillaryWords.contains(wordString.toLowerCase());
    }

    public static Sentence buildSentence(String sentence) {
        if(sentence == null || sentence.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid Sentence");
        }
        return new Sentence(sentence);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sentence) {
            return sentence.equals(((Sentence) obj).sentence);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return sentence.hashCode();
    }

    @Override
    public String toString() {
        return sentence;
    }
}
