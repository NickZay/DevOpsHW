package ru.nickzay.dataservice;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "names")
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    Name(String name) {
        this.name = name;
    }
}
