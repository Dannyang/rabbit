package com.example.rabbit.util;

public class SkipNode<T> {
    int key;
    T value;
    SkipNode<T> right, down;

    public SkipNode(int key, T value) {
        this.key = key;
        this.value = value;
    }
}
