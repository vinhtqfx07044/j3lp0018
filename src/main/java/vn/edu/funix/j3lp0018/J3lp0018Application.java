package vn.edu.funix.j3lp0018;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class J3lp0018Application {
    public static void main(String[] args) {
        SpringApplication.run(J3lp0018Application.class, args);
    }
}
