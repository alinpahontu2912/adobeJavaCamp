package mystageservice.rest.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mystageservice.MyStageService;
import mystageservice.domain.User;
import mystageservice.rest.dto.UserOutputDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final MyStageService myStageService;

    private final ModelMapper modelMapper;

    @GetMapping("users")
    public List<UserOutputDto> getUsers() {
        List<User> allUsers = myStageService.findAll();
        List<UserOutputDto> usersDto = allUsers.stream().map(
                        user -> modelMapper.map(user, UserOutputDto.class))
                .collect(Collectors.toList());
        return usersDto;
    }

    @PostMapping("users")
    public void createNewUser(@RequestBody User user) {
        myStageService.addUser(user);
    }

    @GetMapping("users/{name}")
    public User getUser(@PathVariable String name) {
        return myStageService.findByName(name);
    }
}
