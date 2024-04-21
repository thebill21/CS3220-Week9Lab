package cs3220.w9lab.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cs3220.w9lab.Model.Options;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OptionRepository {
    private final List<Options> options = new ArrayList<>();

//    @Autowired
//    private PollRepository pollRepository;

    public OptionRepository(PollRepository pollRepository) {
        options.add(new Options("Java", pollRepository.findById(1L)));
        options.add(new Options("Python", pollRepository.findById(1L)));
        options.add(new Options("C/C++", pollRepository.findById(1L)));
        options.add(new Options("Michael Jordan", pollRepository.findById(2L)));
        options.add(new Options("Lebron James", pollRepository.findById(2L)));
        options.add(new Options("Kobe Bryant", pollRepository.findById(2L)));

    }

    public List<Options> getAllOptions() {
        return options;
    }

    public void addOption(Options option) {
        options.add(option);
    }

    // Method to find an option by ID
    public Options findById(Long id) {
        for (Options option : options) {
            if (option.getId().equals(id)) {
                return option;
            }
        }
        return null; // Return null if player is not found
    }
}
