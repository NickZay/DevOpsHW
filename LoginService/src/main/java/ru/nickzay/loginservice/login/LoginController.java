package ru.nickzay.loginservice.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/hello")
    public LoginDto hello(@RequestParam String name) throws JsonProcessingException {
        return loginService.getGreetingFor(name);
    }
}
