package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuestionTest {

    @Test (expected = IllegalArgumentException.class)
    public void questionNullTest(){
        Question question = Question.buildQuestion(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void questionEmptyTest(){
        Question question = Question.buildQuestion("");
    }

    @Test (expected = IllegalArgumentException.class)
    public void questionsNullTest(){
        List<Question> questions = Question.buildQuestions(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void questionsEmptyTest(){
        List<Question> questions = Question.buildQuestions(new ArrayList<>());
    }

    @Test
    public void getValidWords(){
        Question question = Question.buildQuestion("How are you, Sooraj?");
        Assert.assertEquals(1, question.getWords().size());
    }

    @Test
    public void questionValidTest(){
        Question question = Question.buildQuestion("Where are you going?");
        Assert.assertEquals(1,question.getWords().size());
        Assert.assertEquals("going",question.getWords().get(0).toString());
    }
}
