package calisma.answerproject.controllers;

import calisma.answerproject.entities.User;
import calisma.answerproject.repositories.UserRepository;
import calisma.answerproject.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.allUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.saveUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getByUserId(@PathVariable Long userId){
        return userService.findById(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User newUser){
        return userService.updateUser(userId, newUser);
        }

    @DeleteMapping("/{userId}")
    public void deleteUserId(@PathVariable Long userId){
         userService.deleteById(userId);
    }
}


