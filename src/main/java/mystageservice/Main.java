package mystageservice;

import mystageservice.domain.Critique;
import mystageservice.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Main {

    private final static ServiceDatabase serviceDatabase = new ServiceDatabase();
    private final static MyStageService myStageService = new MyStageService();

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
        System.out.println("Welcome to demo");
        User user1 = Critique.builder().name("Alin").ratingCount(10).phoneNumber("0422432342").build();
        myStageService.addUser(user1);
        System.out.println(user1.toString());

    }

}


@RestController
class  FirstController {
    @GetMapping("/")
    public String getSomething(){
        return "Hello World Test!";
    }
}