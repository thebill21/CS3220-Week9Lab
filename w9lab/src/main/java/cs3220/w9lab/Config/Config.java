package cs3220.w9lab.Config;

import cs3220.w9lab.Repository.PollRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public PollRepository pollRepository() {
        return new PollRepository();
    }

//    @Bean
//    public PlayerRepository playerRepository(TeamRepository teamRepository) {
//        return new PlayerRepository(teamRepository);
//    }
}
