package ru.nickzay.dataservice.count;

import lombok.Data;

@Data
public class CountDto {
    String name;
    Long count;

    CountDto(CountEntity entity) {
        this.count = entity.getCount();
        this.name = entity.getName();
    }

    static CountDto countDto(CountEntity entity) {
        return new CountDto(entity);
    }
}
