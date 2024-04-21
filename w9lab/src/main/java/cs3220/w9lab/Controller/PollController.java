package cs3220.w9lab.Controller;

import cs3220.w9lab.Repository.OptionRepository;
import cs3220.w9lab.Repository.PollRepository;
import cs3220.w9lab.Model.Poll;
import cs3220.w9lab.Model.Options;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PollController {
    @Autowired
    private final PollRepository pollRepository;
    @Autowired
    private final OptionRepository optionRepository;

    public PollController(PollRepository pollRepository, OptionRepository optionRepository) {

        this.pollRepository = pollRepository;
        this.optionRepository = optionRepository;
    }

    @RequestMapping("/") //show polls
    public String index(Model model) {
        // Fetch all polls and add them to the model
        List<Poll> polls = pollRepository.getAllPolls();
        if (polls != null && !polls.isEmpty()) {
            model.addAttribute("polls", polls);
        }
        return "index"; // Return the view name
    }

    @RequestMapping("/polls/{id}") // Show poll
    public String showPoll(@PathVariable Long id, Model model) {
        // Fetch the poll by ID
        Poll poll = pollRepository.findById(id);

        if (poll != null) {
            // Filter options for the current poll
            List<Options> options = optionRepository.getAllOptions().stream()
                    .filter(option -> option.getPoll().getId().equals(poll.getId()))
                    .collect(Collectors.toList());

            model.addAttribute("poll", poll);
            model.addAttribute("options", options);
            return "pollView"; // Make sure you have a pollView.ftl template
        } else {
            return "redirect:/"; // Redirect to the listing page if the poll is not found
        }
    }

    @PostMapping("/submitPoll/{pollId}")
    public String submitPoll(@PathVariable Long pollId, @RequestParam(value = "options", required = false) List<Long> selectedOptionsIds, RedirectAttributes redirectAttributes) {
        if (selectedOptionsIds == null || selectedOptionsIds.isEmpty()) {
            // Handle the case where no options were selected
            redirectAttributes.addFlashAttribute("error", "You must select at least one option.");
            return "redirect:/polls/" + pollId;
        }

        // Process the selected options here
        // For example, save them to the database, increment vote counts, etc.

        // Redirect to a confirmation page or back to the poll with a success message
        redirectAttributes.addFlashAttribute("success", "Your response has been recorded.");
        return "redirect:/polls/" + pollId; // Or redirect to another confirmation/thank you page
    }

    // Display the "Add Answers" page for a specific poll
    @GetMapping("/addAnswers/{pollId}")
    public String showAddAnswersPage(@PathVariable Long pollId, Model model) {
        Poll poll = pollRepository.findById(pollId);
        List<Options> options = optionRepository.getAllOptions().stream()
                .filter(option -> option.getPoll().getId().equals(poll.getId()))
                .collect(Collectors.toList());

        model.addAttribute("poll", poll);
        model.addAttribute("options", options);

        return "newAnswer"; // Name of the Freemarker template
    }

    // Handle the submission of a new answer
    @PostMapping("/addAnswer/add")
    public String addAnswer(@RequestParam Long pollId, @RequestParam String newAnswer, RedirectAttributes redirectAttributes) {
        Options newOption = new Options(newAnswer, pollRepository.findById(pollId));

        optionRepository.addOption(newOption);

        redirectAttributes.addFlashAttribute("success", "New answer added successfully.");

        return "redirect:/addAnswers/" + pollId; // Redirect back to the "Add Answers" page
    }

    @GetMapping("/newPoll")
    public String showCreatePollPage() {
        return "newPoll"; // Return the view name for creating a new poll
    }

    @PostMapping("/createPoll")
    public String createPoll(@RequestParam String question, @RequestParam(required = false) boolean isSingleChoice, RedirectAttributes redirectAttributes) {
        Poll newPoll = new Poll(question, isSingleChoice);
        pollRepository.addPoll(newPoll); // Assume addPoll method adds the new poll to the list

        redirectAttributes.addFlashAttribute("success", "Poll created successfully.");
        return "redirect:/"; // Redirect to add answers to the new poll
    }
}


