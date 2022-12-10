package ru.nickzay.dataservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class DataServiceApplication {
    private final NamesRepository namesRepository;

    public static void main(String[] args) {
        SpringApplication.run(DataServiceApplication.class, args);
    }

    @GetMapping("/isFirstTimeFor")
    public Boolean sayHello(@RequestParam(defaultValue = "World") String name) {
        if (namesRepository.findByName(name).isEmpty()) {
            namesRepository.save(new Name(name));

            return true;
        }
        return false;
    }

}
