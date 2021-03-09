package pl.kamildlugajczyk.ctf.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(int id) {
        return userRepository.findById(id).get();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getRanking() {
        List<User> users = new ArrayList<>();
        List<UserDTO> usersDTO = new ArrayList<>();

        userRepository.findTop10ByOrderByPointsDesc().forEach(users::add);

        for (User user : users) {
            usersDTO.add(new UserDTO(user.getName(), user.getPoints()));
        }

        return usersDTO;
    }
}
