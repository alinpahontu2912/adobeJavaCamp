package mystageservice;

import lombok.Getter;
import lombok.SneakyThrows;
import mystageservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyStageService {

    private static final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> findAll(){
        return users;
    }

    @SneakyThrows
    public User findByName(String name) {
        return users.stream().filter(user -> user.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new Exception("User does not exist"));
    }

}
