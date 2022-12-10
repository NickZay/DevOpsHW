package ru.nickzay.loginservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static java.lang.Boolean.TRUE;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class LoginServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginServiceApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        var restTemplate = new RestTemplate();
        String url = "http://localhost:7777/isFirstTimeFor?name=" + name;
        return "Hello, " + name + ". " +
                (TRUE.equals(restTemplate.getForObject(url, Boolean.class)) ?
                        " Welcome to the club, buddy." : " Long time no see.");
    }
}
