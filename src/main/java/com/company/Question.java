package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question extends Sentence {

    static String questionMark = "?";
    static Set<String> questionWords = new HashSet<>();


    static {
        questionWords.add("what");
        questionWords.add("when");
        questionWords.add("where");
        questionWords.add("who");
        questionWords.add("which");
        questionWords.add("whom");
        questionWords.add("whose");
        questionWords.add("how");
        questionWords.add("why");
    }

    private Question(String question) {
        super(question);
    }

    protected Boolean isValidWord(String wordString){
        return !wordString.isEmpty() &&
                !auxillaryWords.contains(wordString.toLowerCase()) &&
                !questionWords.contains(wordString.toLowerCase());
    }


    public static Question buildQuestion(String question){
        if(question == null || question.trim().isEmpty()){
            throw  new IllegalArgumentException("Invalid question");
        }
        question = question.trim();
        question = question.endsWith(questionMark) ?
                question.substring(0, question.length() - 1) : question;
        return new Question(question);
    }

    public static List<Question> buildQuestions(List<String> quests){
        List<Question> questions = new ArrayList<>();
        if(quests == null || quests.isEmpty()){
            throw  new IllegalArgumentException("Invalid question");
        }
        for(String quest : quests){
            questions.add(buildQuestion(quest));
        }
        return questions;
    }
}
