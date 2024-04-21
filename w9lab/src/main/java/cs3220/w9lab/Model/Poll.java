package cs3220.w9lab.Model;

import java.util.List;

public class Poll {
    private static Long nextID = 0L;
    private Long id;
    private String question;
    private boolean isSingleChoice;


    public Poll() {}

    public Poll( String question, boolean isSingleChoice) {
        this.id = ++nextID;
        this.question = question;
        this.isSingleChoice = isSingleChoice;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public boolean getIsSingleChoice() {
        return isSingleChoice;
    }

    public void setIsSingleChoice(boolean isSingleChoice) {
        this.isSingleChoice = isSingleChoice;
    }

}


