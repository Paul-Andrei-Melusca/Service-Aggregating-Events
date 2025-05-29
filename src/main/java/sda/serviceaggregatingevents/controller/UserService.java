package sda.serviceaggregatingevents.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sda.serviceaggregatingevents.Entity.User;
import sda.serviceaggregatingevents.Repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}