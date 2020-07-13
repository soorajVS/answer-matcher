package com.company;

import java.util.*;

public class Paragraph {

    private static String delimitter = "[.]";
    private Map<Word, Set<Sentence>> wordToSentenceMap = new HashMap();

    private Paragraph(String paragraph){
        parseParagraph(paragraph);
    }


    private void parseParagraph(String para) {
        List<Sentence> sentences = getSentenceInPara(para);
        for(Sentence sentence : sentences) {
            List<Word> words = sentence.getWords();
            for(Word word : words) {
                Set<Sentence> wordSentences = wordToSentenceMap.get(word);
                if(wordSentences == null){
                    wordSentences = new HashSet<>();
                    wordToSentenceMap.put(word, wordSentences);
                }
                wordSentences.add(sentence);
            }
        }
    }

    private List<Sentence> getSentenceInPara(String para) {
        List<Sentence> sentences = new ArrayList<>();
        String[] sentencesArray =  para.split(delimitter);
        for(String sentence : sentencesArray){
            sentences.add(Sentence.buildSentence(sentence.trim()));
        }
        return sentences;
    }

    public List<Sentence> findMatchingSentencesForQuestion(Question sentence) {
        Map<Sentence,Integer> sentenceCounts = new HashMap<>();
        Set<Sentence> allWordSentences = new HashSet<>();
        List<Word> words = sentence.getWords();
        for(Word word : words) {
            Set<Sentence> wordSentences = getSentencesForWord(word);
            if(wordSentences != null){

                if(allWordSentences.isEmpty()){
                    allWordSentences.addAll(wordSentences);
                }else {
                    allWordSentences.retainAll(wordSentences);
                }

                for(Sentence wordSentence : wordSentences){
                    Integer count = sentenceCounts.get(wordSentence);
                    if(count == null){
                        count = 0;
                    }
                    count++;
                    sentenceCounts.put(wordSentence, count);
                }
            }
        }

        return getSentenceInRank(sentenceCounts, allWordSentences);
    }

    private Set<Sentence> getSentencesForWord(Word word) {
        Set<Sentence> wordSentences = wordToSentenceMap.get(word);
        Word pluralWord  = Word.getPluralOrSingularOf(word);
        if(pluralWord != null) {
            Set<Sentence> pluralWordSentences  = wordToSentenceMap.get(pluralWord);
            if (pluralWordSentences != null) {
                if(wordSentences != null) {
                    wordSentences.addAll(pluralWordSentences);
                } else {
                    wordSentences = pluralWordSentences;
                }
            }
        }
        return wordSentences;
    }

    private List<Sentence> getSentenceInRank(Map<Sentence, Integer> sentenceRank,
                                             Set<Sentence> allWordSentences) {
        List<Sentence> sentencesInDecreasingRank = new ArrayList<>();
        List<SentenceCount> sentenceCounts = new ArrayList<>();

        for(Sentence sentence : allWordSentences){
            sentencesInDecreasingRank.add(sentence);
        }

        for(Map.Entry<Sentence, Integer> entry : sentenceRank.entrySet()){
            sentenceCounts.add(new SentenceCount(entry.getKey(), entry.getValue()));
        }

        sentenceCounts.sort((a, b) -> b.getCount() - a.getCount());

        for (SentenceCount sentenceCount : sentenceCounts) {
            if (!allWordSentences.contains(sentenceCount.getSentence())) {
                sentencesInDecreasingRank.add(sentenceCount.getSentence());
            }
        }
        return sentencesInDecreasingRank;
    }

    public static Paragraph buildParagraph(String paragraph){
        if(paragraph == null || paragraph.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid Paragraph");
        }
        return new Paragraph(paragraph);
    }



    class SentenceCount {
        Sentence sentence;
        int count;

        SentenceCount(Sentence sentence, int count) {
            this.sentence = sentence;
            this.count = count;
        }

        void incrementCount(){
            count += 1;
        }

        int getCount(){
            return count;
        }

        Sentence getSentence(){
            return sentence;
        }
    }

}
