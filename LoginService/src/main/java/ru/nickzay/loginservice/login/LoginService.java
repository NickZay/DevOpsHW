package ru.nickzay.loginservice.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Objects;

import static java.util.Objects.isNull;

@Service
public class LoginService {
    @Value("${DATA_SERVICE_URL}")
    private String dataServiceUrl;

    public LoginDto getGreetingFor(String name) throws JsonProcessingException {
        var restTemplate = new RestTemplate();
        String url = dataServiceUrl + "getCountFor?name=" + name;
        String rs = restTemplate.getForObject(url, String.class);
        CountDto response = new ObjectMapper().readValue(rs, CountDto.class);
        System.out.println(response);
        if (isNull(response) || !Objects.equals(response.getName(), name)) {
            throw new RuntimeException("Bad response from dataservice");
        }
        String greeting = "Hello, " + name + ". You have been " + response.getCount() + " here";
        System.out.println(greeting);
        return LoginDto.builder().greeting(greeting).build();

    }
}
