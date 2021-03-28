package pl.kamildlugajczyk.ctf.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.kamildlugajczyk.ctf.exception.ResourceNotFoundException;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        try {
            return userService.getUser(id);
        } catch (ResourceNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist");
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public void deleteChallenge(@RequestBody User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteChallenge(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
