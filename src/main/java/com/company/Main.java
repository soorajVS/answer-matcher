package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the paragraph:");
        String para = in.nextLine();
        List<String> questions = new ArrayList<>();
        for(int i = 1 ; i <= 5 ; i ++) {
            System.out.println("Enter question " + i + " :");
            String s = in.nextLine();
            questions.add(s);
        }

        System.out.println("Enter the jumbled answers:");
        String jumbledAnswers = in.nextLine();

        List<String> answers =
                QuestionAnswerMatcher.matchAnswers(para,questions,jumbledAnswers);

        System.out.println("Ordered answers are :");
        for(String answer : answers) {
            System.out.println(answer);
        }

    }
}
