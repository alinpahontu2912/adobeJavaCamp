package mystageservice.services;

import mystageservice.domain.User;
import mystageservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String name) throws Exception {
        User user = userRepository.findFirstByName(name);
        if (user == null) throw new Exception("User not found");
        return user;
    }

}
