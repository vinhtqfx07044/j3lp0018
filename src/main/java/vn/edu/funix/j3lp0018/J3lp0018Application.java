package vn.edu.funix.j3lp0018;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

 @SpringBootApplication @ServletComponentScan // To scan for components like @WebListener (for SessionListener later)
public class J3lp0018Application {

    public static void main(String[] args) {
        SpringApplication.run(J3lp0018Application.class, args);
    }

}
