package com.example.rabbit.config.test;

public enum SqlOperationEnum {
    IN("IN"),
    LITTLE_THAN("<="),
    BIGGER_THAN(">="),
    EQUAL("=");
    private final String operation;

    SqlOperationEnum(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return this.operation;
    }
}
