package pl.kamildlugajczyk.ctf.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ChallengeController {

    @Autowired
    ChallengeService challengeService;

    @RequestMapping("/challenges")
    public List<Challenge> getAllChallenges() {
        return challengeService.getAllChallenges();
    }

    @RequestMapping("/challenges/{id}")
    public Challenge getChallenge(@PathVariable int id) {
        return challengeService.getChallenge(id);
    }
}
