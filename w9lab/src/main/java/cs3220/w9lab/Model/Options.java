package cs3220.w9lab.Model;

import java.util.List;

public class Options {
    private static Long nextID = 0L;
    private Long id;
    private String options;
    private Poll poll; // Reference to the Poll this Option belongs to

    public Options() {}

    public Options(String options, Poll poll) {
        this.id = ++nextID;
        this.options = options;
        this.poll = poll;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption() {
        return options;
    }

    public void setText(String options) {
        this.options = options;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }


}
