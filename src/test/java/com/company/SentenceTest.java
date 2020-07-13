package com.company;

import org.junit.Assert;
import org.junit.Test;

public class SentenceTest {

    @Test(expected = IllegalArgumentException.class)
    public void nullSentenceTest(){
        Sentence sentence = Sentence.buildSentence(null);

    }

    @Test (expected = IllegalArgumentException.class)
    public void emptylSentenceTest(){
        Sentence sentence = Sentence.buildSentence("");

    }

    @Test
    public void validSentenceTest(){
        Sentence sentence = Sentence.buildSentence("Good day");
    }

    @Test
    public void testToString(){
        Sentence sentence = Sentence.buildSentence("Good day");
        Assert.assertEquals(sentence.toString(), "Good day");
    }

    @Test
    public void getAllWords(){
        Sentence sentence = Sentence.buildSentence("Mary, Jack, good morning");
        Assert.assertEquals(4, sentence.getWords().size());
    }

    @Test
    public void getValidWords(){
        Sentence sentence = Sentence.buildSentence("How are you, Sooraj?");
        Assert.assertEquals(2, sentence.getWords().size());
    }
}
