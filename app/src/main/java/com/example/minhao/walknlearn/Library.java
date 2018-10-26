package com.example.minhao.walknlearn;

public class Library {

    private String questions [] = {
            "Which question is correct.",
            "which question is correct.",
            "which question is correct.",
            "which question is correct."
    };

    //Two Dimensional Array
    private String choice [][] = {
            {"abc", "def", "gril"},
            {"abc", "def", "girl"},
            {"bdh", "qwex", "hjur"},
            {"asgg", "awdg", "adwaq"}
    };

    private String correctAnswers[] = {
            "def", "abc", "bdh", "adwaq"
    };

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getChoice0(int a){
        String choice0 = choice[a][0];
        return choice0;
    }

    public String getChoice1(int a){
        String choice1 = choice[a][1];
        return choice1;
    }
    public String getChoice2(int a){
        String choice2 = choice[a][2];
        return choice2;
    }
    //Return the Correct Answer
    public String getCorrectAnswer(int a){
        String answer = correctAnswers[a];
        return answer;
    }
}
