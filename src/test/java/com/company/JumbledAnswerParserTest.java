package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class JumbledAnswerParserTest {

    @Test
    public void nullStringInputTest() {
        List<Sentence> answers = JumbledAnswerParser.getAllAnswers(null);
        Assert.assertNotNull(answers);
        Assert.assertEquals(0, answers.size());
    }

    @Test
    public void validStringTest(){
        List<Sentence> answers = JumbledAnswerParser.getAllAnswers("subgenus Hippotigris; " +
                "the plains zebra, the Grévy's zebra and the" +
                "mountain zebra;horses and donkeys;" +
                "aims to breed zebras that are" +
                "phenotypically similar to the quagga; " +
                "Grévy's zebra and the mountain" +
                "zebra");
        Assert.assertNotNull(answers);
        Assert.assertEquals(5, answers.size());
        Assert.assertEquals("horses and donkeys", answers.get(2).toString());
    }
}
