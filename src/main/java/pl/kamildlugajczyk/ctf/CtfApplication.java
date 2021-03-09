package pl.kamildlugajczyk.ctf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.kamildlugajczyk.ctf.challenge.ChallengeRepository;
import pl.kamildlugajczyk.ctf.history.HistoryRepository;
import pl.kamildlugajczyk.ctf.user.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = { UserRepository.class, ChallengeRepository.class, HistoryRepository.class})
public class CtfApplication {

    public static void main(String[] args) {
        SpringApplication.run(CtfApplication.class, args);
    }

}
