package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ParagraphTest {

    @Test (expected = IllegalArgumentException.class)
    public void nullParagraphTest(){
        Paragraph.buildParagraph(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void emptyParagraphTest(){
        Paragraph.buildParagraph("");
    }

    @Test
    public void validParagraphTest(){
        Paragraph para = Paragraph.buildParagraph("It drizzled all through out the day. The smell of petrichor will entice you");
    }

    private Paragraph buildParaForTest() {
        return Paragraph.buildParagraph(
                "Zebras are several species of African equids (horse family) united by their distinctive black" +
                        " and white stripes. Their stripes come in different patterns, unique to each individual." +
                        " They are generally social animals that live in small harems to large herds." +
                        " Unlike their closest relatives, horses and donkeys, zebras have never been truly domesticated." +
                        " There are three species of zebras: the plains zebra, the Grévy's zebra and the mountain zebra." +
                        " The plains zebra and the mountain zebra belong to the subgenus Hippotigris, but Grévy's zebra" +
                        " is the sole species of subgenus Dolichohippus. The latter resembles an ass," +
                        " to which it is closely related, while the former two are more horse-like. All three belong to" +
                        " the genus Equus, along with other living equids. The unique stripes of zebras make them one of" +
                        " the animals most familiar to people. They occur in a variety of habitats, such as grasslands," +
                        " savannas, woodlands, thorny scrublands, mountains, and coastal hills." +
                        " However, various anthropogenic factors have had a severe impact on zebra populations," +
                        " in particular hunting for skins and habitat destruction. Grévy's zebra" +
                        " and the mountain zebra are endangered. While plains zebras are much more plentiful," +
                        " one subspecies - the Quagga - became extinct in the late 19th century. Though there is" +
                        " currently a plan, called the Quagga Project, that aims to breed zebras that are phenotypically" +
                        " similar to the Quagga, in a process called breeding back.");
    }

    @Test
    public void findMatchingSentencesForQuestionTest() {

        Paragraph para = buildParaForTest();

        List<Sentence> sentences =
                para.findMatchingSentencesForQuestion(Question.buildQuestion("Which Zebras are endangered?"));
        Assert.assertNotNull(sentences);
        Assert.assertTrue(sentences.size() > 0);
        Assert.assertEquals("Grévy's zebra and the mountain zebra are endangered",sentences.get(0).toString());
    }

    @Test
    public void findMatchingSentencesForQuestionTwoTest() {

        Paragraph para = buildParaForTest();

        List<Sentence> sentences =
                para.findMatchingSentencesForQuestion(Question.buildQuestion("What is the aim of the Quagga Project?"));
        Assert.assertNotNull(sentences);
        Assert.assertTrue(sentences.size() > 0);
        Assert.assertEquals("Though there is" +
                " currently a plan, called the Quagga Project, that aims to breed zebras that are phenotypically" +
                " similar to the Quagga, in a process called breeding back",sentences.get(0).toString());
    }

    @Test
    public void findMatchingSentencesForQuestionThreeTest() {

        Paragraph para = buildParaForTest();

        List<Sentence> sentences =
                para.findMatchingSentencesForQuestion(Question.buildQuestion("Which animals are some of their closest relatives?"));
        Assert.assertNotNull(sentences);
        Assert.assertTrue(sentences.size() > 0);
        Assert.assertEquals("Unlike their" +
                " closest relatives, horses and donkeys, zebras have never been truly" +
                " domesticated",sentences.get(0).toString());
    }

    @Test
    public void findMatchingSentencesForQuestionFourTest() {

        Paragraph para = buildParaForTest();

        List<Sentence> sentences =
                para.findMatchingSentencesForQuestion(Question.buildQuestion("Which are the three species of zebras?"));
        Assert.assertNotNull(sentences);
        Assert.assertTrue(sentences.size() > 0);
        Assert.assertEquals("There are three species of zebras: the plains zebra," +
                " the Grévy's zebra and the mountain zebra", sentences.get(0).toString());
    }

    @Test
    public void findMatchingSentencesForQuestionFiveTest() {

        Paragraph para = buildParaForTest();

        List<Sentence> sentences =
                para.findMatchingSentencesForQuestion(Question.buildQuestion("Which" +
                        " subgenus do the plains zebra and the mountain zebra belong to?"));
        Assert.assertNotNull(sentences);
        Assert.assertTrue(sentences.size() > 0);
        Assert.assertEquals("The plains zebra and the mountain zebra belong to the subgenus Hippotigris, but Grévy's zebra" +
                " is the sole species of subgenus Dolichohippus", sentences.get(0).toString());
    }
}
