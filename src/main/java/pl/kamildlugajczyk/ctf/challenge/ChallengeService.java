package pl.kamildlugajczyk.ctf.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    public List<Challenge> getAllChallenges() {
        List<Challenge> challenges = new ArrayList<>();
        challengeRepository.findAll().forEach(challenges::add);
        return challenges;
    }

    public Challenge getChallenge(int id) {
        return challengeRepository.findById(id).get();
    }

    public void addChallenge(Challenge challenge) {
        challengeRepository.save(challenge);
    }

    public void updateChallenge(Challenge challenge) {
        challengeRepository.save(challenge);
    }

    public void deleteChallenge(int id) {
        challengeRepository.deleteById(id);
    }
}
