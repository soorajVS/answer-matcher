package com.company;

import org.junit.Test;

public class WordTest {

    @Test (expected = IllegalArgumentException.class)
    public void nullWordTest(){
        Word word = Word.buildWord(null);

    }

    @Test (expected = IllegalArgumentException.class)
    public void emptylWordTest(){
        Word word = Word.buildWord("");

    }

    @Test
    public void validWordTest(){
        Word word = Word.buildWord("Morning");
    }
}
