package ssafy.com.kkyuwoo.happyhouse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ssafy.com.kkyuwoo.happyhouse.domain.board.*;
import ssafy.com.kkyuwoo.happyhouse.domain.user.Role;
import ssafy.com.kkyuwoo.happyhouse.domain.user.SocialType;
import ssafy.com.kkyuwoo.happyhouse.domain.user.User;
import ssafy.com.kkyuwoo.happyhouse.domain.user.UserRepository;

import java.util.stream.IntStream;

@SpringBootApplication
public class HappyhouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HappyhouseApplication.class, args);
    }

}
