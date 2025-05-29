package sda.serviceaggregatingevents.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sda.serviceaggregatingevents.Entity.User;
import sda.serviceaggregatingevents.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {return userRepository.save(user);}

    public Optional<User>getUserById(Long id) {return userRepository.findById(id);}

    public List<User> getAllUsers() {return userRepository.findAll();}

    public void deleteUserById(Long id) {userRepository.deleteById(id);}

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());

        return userRepository.save(user);
    }



}
