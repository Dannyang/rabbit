package com.example.rabbit.config.test;

public abstract class PostDeal {
    private final StringBuilder stringBuilder;

    public PostDeal(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    abstract <T> void postSet(String tagKey, String tagName, String listVal, T leftVal, T rightVal);

    public StringBuilder getSql() {
        return this.stringBuilder;
    }
}
