package pl.kamildlugajczyk.ctf.challenge;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ChallengeService {

    private List<Challenge> challenges = Arrays.asList(
            new Challenge("Basic injection", 1, "Very easy and basic SQL Injection", 30, 4.58,"easy", "Basic_injection_flag"),
            new Challenge("Forensics 101", 2, "...", 30, 4.43,"easy", "Forensics_101_flag"),
            new Challenge("Practise Flag", 3, "...", 20, 3.13,"easy", "Practise_Flag_flag"),
            new Challenge("Raking LS", 4, "...", 30, 3.75,"easy", "Raking_LS_flag"),
            new Challenge("Character Encoding", 5, "...", 20, 4.31,"easy", "Character_Encoding_flag")
    );

    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    public Challenge getChallenge(int id) {
        for (Challenge challenge : challenges) {
            if (challenge.getId() == id)
                return challenge;
        }
        return null;
    }
}
