package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuestionAnswerMatcherTest {

    @Test (expected = IllegalArgumentException.class)
    public void nullParaTest(){
        ArrayList<String> questions = new ArrayList<>();
        questions.add("what should throw exception?");
        QuestionAnswerMatcher.matchAnswers(null,questions,"Testing null para");
    }

    @Test (expected = IllegalArgumentException.class)
    public void nullQuestionsTest(){
        QuestionAnswerMatcher.matchAnswers("Testing null questions, It should throw exception",null,"answer1;answer2");
    }

    @Test (expected = IllegalArgumentException.class)
    public void nullAnswerTest(){
        ArrayList<String> questions = new ArrayList<>();
        questions.add("what should throw exception?");
        QuestionAnswerMatcher.matchAnswers("Testing null answer, It should throw exception",questions,null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void emptyParaTest(){
        ArrayList<String> questions = new ArrayList<>();
        questions.add("what should throw exception?");
        QuestionAnswerMatcher.matchAnswers("",questions,"Testing null para");
    }

    @Test (expected = IllegalArgumentException.class)
    public void emptyQuestionsTest(){
        QuestionAnswerMatcher.matchAnswers("Testing null questions, It should throw exception",new ArrayList<>(),"answer1;answer2");
    }

    @Test (expected = IllegalArgumentException.class)
    public void emptyAnswerTest(){
        ArrayList<String> questions = new ArrayList<>();
        questions.add("what should throw exception?");
        QuestionAnswerMatcher.matchAnswers("Testing null answer, It should throw exception",questions,"");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidQuestionCounts(){
        String para = getPara();
        List<String> questions = getQuestions();
        questions.remove(0);
        String jumbledAnswers = getJumbledAnswers();
        List<String> answers = QuestionAnswerMatcher.matchAnswers(para,questions,jumbledAnswers);
        Assert.assertNotNull(answers);
        Assert.assertEquals(5, answers.size());
        Assert.assertEquals("Grévy's zebra and the mountain zebra", answers.get(0));
        Assert.assertEquals("aims to breed zebras that are phenotypically similar to the quagga", answers.get(1));
        Assert.assertEquals("horses and donkeys", answers.get(2));
        Assert.assertEquals("the plains zebra, the Grévy's zebra and the mountain zebra", answers.get(3));
        Assert.assertEquals("subgenus Hippotigris", answers.get(4));
    }


    @Test
    public void matchCorrectAnswer(){
        String para = getPara();
        List<String> questions = getQuestions();
        String jumbledAnswers = getJumbledAnswers();
        List<String> answers = QuestionAnswerMatcher.matchAnswers(para,questions,jumbledAnswers);
        Assert.assertNotNull(answers);
        Assert.assertEquals(5, answers.size());
        Assert.assertEquals("Grévy's zebra and the mountain zebra", answers.get(0));
        Assert.assertEquals("aims to breed zebras that are phenotypically similar to the quagga", answers.get(1));
        Assert.assertEquals("horses and donkeys", answers.get(2));
        Assert.assertEquals("the plains zebra, the Grévy's zebra and the mountain zebra", answers.get(3));
        Assert.assertEquals("subgenus Hippotigris", answers.get(4));
    }

    private String getPara() {
        return "Zebras are several species of African equids (horse family) united by their distinctive black" +
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
                " similar to the Quagga, in a process called breeding back.";
    }

    private List<String> getQuestions() {
        List<String> questions = new ArrayList<>();
        questions.add("Which Zebras are endangered?");
        questions.add("What is the aim of the Quagga Project?");
        questions.add("Which animals are some of their closest relatives?");
        questions.add("Which are the three species of zebras?");
        questions.add("Which subgenus do the plains zebra and the mountain zebra belong to?");
        return questions;
    }

    private String getJumbledAnswers(){
        return  "subgenus Hippotigris; the plains zebra," +
                " the Grévy's zebra and the mountain zebra;horses and donkeys;" +
                "aims to breed zebras that are phenotypically similar to the quagga;" +
                " Grévy's zebra and the mountain zebra";
    }


}
