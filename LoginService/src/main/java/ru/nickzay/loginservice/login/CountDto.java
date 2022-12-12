package ru.nickzay.loginservice.login;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountDto {
    String name;
    Long count;
}
