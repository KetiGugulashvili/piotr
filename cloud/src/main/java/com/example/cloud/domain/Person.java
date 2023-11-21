package com.example.cloud.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
}
