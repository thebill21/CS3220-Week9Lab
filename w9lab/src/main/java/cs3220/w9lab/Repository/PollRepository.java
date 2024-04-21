package cs3220.w9lab.Repository;

import cs3220.w9lab.Model.Options;
import cs3220.w9lab.Model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PollRepository {
    private final List<Poll> polls = new ArrayList<>();

    public PollRepository() {
        polls.add(new Poll("What programming language do you know?", false));
        polls.add(new Poll("Who is the greatest basketball player ever?", true));
    }

    public Poll findById(Long id) {
        return polls.stream().filter(polls -> polls.getId().equals(id)).findFirst().orElse(null);
    }
    public List<Poll> getAllPolls() {
        return polls;
    }

    public void addPoll(Poll poll) {
        polls.add(poll);
    }
}

