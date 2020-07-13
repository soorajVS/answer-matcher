package com.company;

import java.util.*;

public class QuestionAnswerMatcher {

    public static List<String> matchAnswers(String paragraph, List<String> quests, String jumbledAnswerParser) {
        List<String> orderedAnswers = new ArrayList<>();
        Paragraph para = Paragraph.buildParagraph(getFilteredString(paragraph));
        if (quests != null && !quests.isEmpty() && jumbledAnswerParser != null && !jumbledAnswerParser.isEmpty()) {

            List<Sentence> jumbledAnswers = JumbledAnswerParser.getAllAnswers(getFilteredString(jumbledAnswerParser));
            List<Question> questions = Question.buildQuestions(quests);
            if(jumbledAnswers.size() != questions.size()){
                throw new IllegalArgumentException("Number of questions do not match");
            }
            for (Question question : questions) {
                boolean answerFound = false;
                List<Sentence> matchingSentences = para.findMatchingSentencesForQuestion(question);
                for (Sentence sentence : matchingSentences) {
                    Iterator<Sentence> iter = jumbledAnswers.iterator();
                    while (iter.hasNext()) {
                        String answer = iter.next().toString();
                        if (sentence.toString().toLowerCase().contains(answer.toLowerCase())) {
                            orderedAnswers.add(answer);
                            iter.remove();
                            answerFound = true;
                            break;
                        }
                    }
                    if (answerFound) {
                        break;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid Input");
        }
        return orderedAnswers;
    }


    private static String getFilteredString(String s){
        String returnVal = null;
        if(s != null){
            returnVal = s.replaceAll("[\n\t]","");
        }
        return returnVal;
    }
}
