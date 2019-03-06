package com.borodin.server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Entity {

    private String firstName;

    private String lastName;

    private String login;

    private String password;

    private String phone;

    private String email;

    private Role role;
}
