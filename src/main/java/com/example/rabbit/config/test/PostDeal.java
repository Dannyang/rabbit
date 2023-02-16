package com.example.rabbit.config.test;

import java.util.List;
import java.util.stream.Collectors;

public abstract class PostDeal {
    private final StringBuilder stringBuilder;

    public PostDeal(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    abstract <T> void postSet(String tagKey, String tagName, List<T> listVal, T leftVal, T rightVal);

    protected StringBuilder getSqlBuilder() {
        return this.stringBuilder;
    }

    protected  <T>String getListVal(List<T> listVal) {
        return "(".concat(listVal.stream().map(a -> "'".concat(String.valueOf(a)).concat("'")).collect(Collectors.joining(","))).concat(")");
    }
}
