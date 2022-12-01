package com.example.rabbit.config.test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Strategy {
    public static Map<String, Function<String, String>> map = new HashMap<>();
    public String t1(String str) {
        return str + "1";
    }
    public String t2(String str) {
        return str + "2";
    }
    public String t3(String str) {
        return str + "3";
    }
    public void  setMap(String str){
//        Function<String, String> function = s -> this::t1;
    }
}
