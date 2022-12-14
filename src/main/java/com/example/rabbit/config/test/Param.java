package com.example.rabbit.config.test;

public class Param {
    private final String code;
    private final Object value;
    private final SqlOperationEnum operation;

    public Param(String code, Object value, SqlOperationEnum operation) {
        this.code = code;
        this.value = value;
        this.operation = operation;
    }

    public Object getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }

    public String getOperation() {
        return this.operation.getOperation();
    }
}
