package com.example.minhao.walknlearn;

public class Library {

    private String questions [] = {
            "1. Which of the following correctly states the content of a system catalog?",
            "2. Which of these is a defining characteristic of relational data models?",
            "3. Why is the three level architecture useful to DBAs?",
            "4. What does DAC stand for?",
            "5. Someone sending data being sure that data is being received by genuine receiver over the internet refers to what concept?",
            "6. Which is not a security measure for DBMS and the web?",
            "7. What is meant by system definition?",
            "8. What are the 4 phases of unified process (UP) SDLC?",
            "9. What is the purpose of a feasibility analysis?",
            "10. What did Bill Inmon contribute to the normalisation?",
            ""
    };

    //Two Dimensional Array
    private String choice [][] = {
            {"Usage statistics, names of users, constraints on data", "Metadata, user views, OOP structure", "Classes, objects, methods"},
            {"structural independence", "parent classes", "Inheritance"},
            {"They are able to change database storage structures without affecting the users views.", "They can access various levels of data without authorisation barriers", "Users and user views clearly defined in three categories making it easier for DBA to modify "},
            {"Discretionary Access Control", "Database Authorisation Control", "Database Access Control"},
            {"Non fabrication", "Integrity", "Non repudiation"},
            {"Firewall", "Anti virus applications", "ActiveX security"},
            {"Describes scope and boundaries of database system and major user views", "Refers to the system catalog and metadata needed for a system", "Defines the intended end users of a system and the user views"},
            {"Inception, elaboration, construction, transition", "Planning, Analysis, design, implementation", "Define, ideate, prototype, test"},
            {"To analyse the technical and economical aspects of a project", "To determine the viability of projects and the stakeholders involved", "To provide DAs and DBAs with visualisation of a project at a certain point in time "},
            {"Described situations where 2NF is better than 3NF", "Defined third normalisation as a table in 2nd normal form, and contains only columns that are non-transitively dependent on the primary key", "Coined the concept of Partial Dependency"},
            {"","",""}
    };

    private String correctAnswers[] = {
            "Usage statistics, names of users, constraints on data", "structural independence", "They are able to change database storage structures without affecting the users views.", "Discretionary Access Control","Non fabrication",
            "Firewall","Describes scope and boundaries of database system and major user views","Inception, elaboration, construction, transition","To analyse the technical and economical aspects of a project","Described situations where 2NF is better than 3NF",""
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
