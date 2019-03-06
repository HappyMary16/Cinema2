package com.borodin.server.domain;

public enum Role {

    ADMIN(1), USER(2), ACTOR(3), DIRECTOR(4);

    private int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Role getInstance(int id) {
        return Role.values()[id - 1];
    }
}
