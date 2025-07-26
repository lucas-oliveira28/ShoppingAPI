package com.lucasmonteiro.shoppingapi.entities.enums;

public enum UserLevel {
    ADMIN(1),
    EMPLOYEE(2),
    CLIENT(3);

    private int code;

    private UserLevel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static UserLevel valueOf(int code) {
        for (UserLevel value : UserLevel.values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid User Level: " + code);
    }
}
