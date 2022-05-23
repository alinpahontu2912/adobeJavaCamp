package mystageservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mystageservice.domain.User;
import mystageservice.dto.UserOutputDto;
import mystageservice.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {


    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("users")
    public List<UserOutputDto> getUsers() {
        List<User> allUsers = userService.findAll();
        List<UserOutputDto> usersDto = allUsers.stream().map(
                        user -> modelMapper.map(user, UserOutputDto.class))
                .collect(Collectors.toList());
        return usersDto;
    }

    @PostMapping("users")
    public void createNewUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("users")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

    @GetMapping("users/{name}")
    public User getUser(@PathVariable String name) throws Exception {
        return userService.findById(name);
    }
}
