package mystageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    private final static ServiceDatabase serviceDatabase = new ServiceDatabase();
    private final static MyStageService myStageService = new MyStageService();

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }

}
