package mystageservice.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mystageservice.domain.User;
import mystageservice.dto.UserOutputDto;
import mystageservice.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class UserController {


    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("users")
    public ResponseEntity<?> getUsers() {
        List<User> allUsers = userService.findAll();
        List<UserOutputDto> usersDto = allUsers.stream().map(
                        user -> modelMapper.map(user, UserOutputDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(usersDto);
    }

    @PostMapping("users")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        User newUser = userService.addUser(user, "asasd");
        return newUser != null ? ResponseEntity.ok(newUser) : ResponseEntity.badRequest().body("Can't add user, woops");
    }

    @DeleteMapping("users")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

    @GetMapping("users/{name}")
    public ResponseEntity<?> getUser(@PathVariable String name) throws Exception {
        return ResponseEntity.ok(modelMapper.map(userService.findById(name), UserOutputDto.class));
    }
}
