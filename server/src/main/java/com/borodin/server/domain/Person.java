package com.borodin.server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends Entity {

    private String firstName;

    private String lastName;

    private Role role;
}
