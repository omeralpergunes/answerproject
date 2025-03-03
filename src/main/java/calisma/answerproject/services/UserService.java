package calisma.answerproject.services;

import calisma.answerproject.entities.User;
import calisma.answerproject.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User findById(Long userId) {
        return (userRepository.findById(userId).orElse(null));
    }

    public User updateUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUsername(newUser.getUsername());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);

            return foundUser;
        } else
            return null;
        }
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
