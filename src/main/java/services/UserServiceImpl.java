package services;

import exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import models.User;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The user with ID was not found: " + id));
    }
}
