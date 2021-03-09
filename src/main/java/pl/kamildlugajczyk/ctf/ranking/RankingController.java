package pl.kamildlugajczyk.ctf.ranking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kamildlugajczyk.ctf.user.User;
import pl.kamildlugajczyk.ctf.user.UserDTO;
import pl.kamildlugajczyk.ctf.user.UserRepository;
import pl.kamildlugajczyk.ctf.user.UserService;

import java.util.List;

@RestController
public class RankingController {

    @Autowired
    private UserService userService;

    @RequestMapping("/ranking")
    public List<UserDTO> getRanking() {
        return userService.getRanking();
    }
}
