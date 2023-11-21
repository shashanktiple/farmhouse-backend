package org.app.farmhouse.constants;

public enum AddressType {
    HOME("HOME"),
    BUSINESS("BUSINESS");


    private String type;

    AddressType(String value) {
        this.type = value;
    }
}
