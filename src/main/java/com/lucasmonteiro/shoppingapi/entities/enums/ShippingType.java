package com.lucasmonteiro.shoppingapi.entities.enums;

public enum ShippingType {
    ECONOMIC(1),
    PRIORITY(2),
    LOCAL_DELIVERY(3),
    PICKUP(4);

    private int code;

    private ShippingType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ShippingType valueOf(int code) {
        for (ShippingType value : ShippingType.values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid User Level: " + code);
    }
}
