package ru.nickzay.dataservice.count;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static ru.nickzay.dataservice.count.CountDto.countDto;

@Service
@AllArgsConstructor
public class CountService {
    private CountsRepository countsRepository;

    public CountDto getCountFor(String name) {
        return countDto(countsRepository.findByName(name).orElseGet(
                () -> countsRepository.save(CountEntity.builder().name(name).count(0L).build())
        ));
    }
}
