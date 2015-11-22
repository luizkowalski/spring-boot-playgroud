package tv.tweek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(ApiApplication.class);
        app.run(args);
    }
}
