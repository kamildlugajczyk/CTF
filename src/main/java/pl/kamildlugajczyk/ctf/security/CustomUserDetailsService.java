package pl.kamildlugajczyk.ctf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.kamildlugajczyk.ctf.user.User;
import pl.kamildlugajczyk.ctf.user.UserRepository;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByName(name);
        user.orElseThrow(() -> new UsernameNotFoundException("User " + name + " not found!"));

        return user.map(CustomUserDetails::new).get();
    }
}
