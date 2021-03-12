package pl.kamildlugajczyk.ctf.flag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.kamildlugajczyk.ctf.challenge.Challenge;
import pl.kamildlugajczyk.ctf.challenge.ChallengeRepository;
import pl.kamildlugajczyk.ctf.history.History;
import pl.kamildlugajczyk.ctf.history.HistoryRepository;
import pl.kamildlugajczyk.ctf.security.CustomUserDetails;
import pl.kamildlugajczyk.ctf.security.JwtTokenProvider;
import pl.kamildlugajczyk.ctf.user.User;
import pl.kamildlugajczyk.ctf.user.UserRepository;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FlagService {

    @Autowired
    ChallengeRepository challengeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    private JwtTokenProvider jwtToken;

    public boolean validateFlag(Flag flag) {

        Optional<Challenge> challenge = challengeRepository.findById(flag.getChallengeId());
        if (challenge.orElseThrow(() -> new NoSuchElementException("Challenge " + flag.getChallengeId() + " not found!"))
            .getFlag().equals(flag.getFlag())) {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();

            Optional<User> user = userRepository.findByName(currentPrincipalName);
            user.orElseThrow(() -> new UsernameNotFoundException("User " + currentPrincipalName + " not found!"));

            for (History history : user.get().getHistory()) {
                if (history.getChallengeId() == challenge.get().getId())
                    return false;
            }

            History history = new History(user.get(), challenge.get(), LocalDate.now(), challenge.get().getPoints(), 0);
            user.get().addPoints(challenge.get().getPoints());

            user.get().updateHistory(history);
            userRepository.save(user.get());

            return true;
        }

        return false;
    }
}
