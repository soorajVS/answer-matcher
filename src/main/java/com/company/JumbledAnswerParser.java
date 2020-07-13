package com.company;

import java.util.ArrayList;
import java.util.List;

public class JumbledAnswerParser {

    static String delimitter = ";";

    public static List<Sentence> getAllAnswers(String jumbledAnswer) {
        List<Sentence> answerSentences = new ArrayList<>();
        if (jumbledAnswer != null && !jumbledAnswer.isEmpty()) {
            String[] answers = jumbledAnswer.split(delimitter);
            for (String answer : answers) {
                answerSentences.add(Sentence.buildSentence(answer.trim()));
            }
        }
        return answerSentences;
    }
}
